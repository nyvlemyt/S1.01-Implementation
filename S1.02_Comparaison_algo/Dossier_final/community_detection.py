friends = ["Alice","Bob","Bob","Charlie","Alice","Dominique","Bob","Dominique"]

#Question 1: 
def create_network (list_of_friend):
    """ It is the same of dico_reseau but here, we use an other technique. 
    It takes as parameter an array of pairs of friends and returns the associated network."""
    i = 0 
    net = {}
    while i < len(list_of_friend):
        couple = list_of_friend[i], list_of_friend[i+1] #to keep the good personnes.
        y = 0
        z = 1
        while y < 2 :
            if couple[y] in list(net) :
                net[couple[y]].append(couple[z]) #if one is already in the dictionary, it adds the other in its values
            else:
                tab = [couple[z]] #creation of a table for the values
                net[couple[y]] = tab #adds the table as a value to the other person
            
            y += 1
            z -= 1
       
        i += 2
        
    return net

#Question 3: 
def get_people (network) :
    """This function takes a network as parameter and returns the list of people in this network in an array."""
    return list(network) 

#Question 4: 
def are_friend (network, first_people, second_people):
    """This function takes as parameters a network and two people. 
    The function should return True if the two people are friends, and False otherwise."""
    return second_people in network[first_people]

#Question 5:
def all_his_friends (network, people, group):
    """This function takes as parameters network, a person and a group of people and returns True 
    if the person is friendly with all the people of the group, and False otherwise."""
    if people not in network :
        return False #returns false if the person is not in the network 
    
    friend_people = network[people] #sort the person's friends
    i = 0
    while i < len(group):
        if group[i] not in friend_people :
            return False #returns false if person i in group is not in friend_people
        i+=1
    return True  

#Question 6:
def is_a_community (network, peoples_group):
    """This function takes as parameters a dictionary modeling the network and a group of people (array of people) 
    and returns True if this group is a community, and False otherwise."""
    i = 0
    while i < len(peoples_group):
        people = peoples_group[i] #take a person from the group to do some tests
        if people not in network:
            return False #returns False if the person is not in the network 
        y = i + 1 #initializing a counter testing all people after "people"
        while y < len(peoples_group) :
            if not peoples_group[y] in network[people]: 
                return False #check if the people in the group are in the "people" friends list
            y += 1
        i += 1
    return True 

#Question 7:
def find_community (network, group):
    """This function takes a network and a group of people as parameters 
    and returns a community according to the heuristic described above. 
    The order of the people will be given by the order of the people in the table corresponding to the group.
    To find a maximum community in a network, we start from an empty community and consider the people one after the other. 
    For each person, if this one is friendly with all the members of the community already created, 
    then we add it to the community."""
    
    new_group = group.copy()
    commu = [] 
    commu.append(new_group[0]) #add the 1st person of the group
    i = 1
    while i < len(group):
        if all_his_friends(network, new_group[i], commu ) == True: #test if the person in the group is friends with the whole community
            commu.append(new_group[i])
        i+=1
    return commu
tab = ("Alice","Bob","Charlie","Dominique","Antoine")
#Question 8:
def friends_number_of_people (network):
    """This function returns a dictionary of people classified by their number of friends and takes as parameter a network."""
    people = list(network) #retrieves the list of people
    friends = list(network.values()) #get the friends from the list of people
    net = network.copy() #copy the network to not modify it 
    i=0
    while i< len(people):
        net[people[i]] = len(friends[i]) #gives as value the number of friends
        i += 1
    
    numbers = list(net.values()) #sort these numbers
    numbers.sort() #sort the list of numbers
    numbers.reverse() #puts the list in descending order
    new_people = [] 
    
    i = 0
    while i < len(people):
        place = numbers.index(net[people[i]]) #know the position of the number of friends of a person in the list of numbers
        new_people.insert(place,people[i]) #Put this person in the same position in new_people
        i += 1
        
    i = 0
    new_network = {}
    while i < len(people):
        new_network[new_people[i]] = numbers[i] #add in new dictionary each person and his value
        i += 1
    
    
    return new_network

def order_by_decreasing_popularity (network, people_group) :
    """This function takes a network and a group of people as parameters and 
    sorts the group of people by decreasing popularity (number of friends)."""
    new_network = list(friends_number_of_people(network)) #sort network keys in descending order
    i = 0
    pop= []
    while i < len(new_network):
        if new_network[i] in people_group: #test if a person of the network is in the tested group 
            pop.append(new_network[i])
        i +=1
    return pop

#Question 9:
def find_community_by_decreasing_popularity (network): 
    """This function takes a network as parameter. 
    The function must sort the set of people in the network according to the decreasing order of popularity 
    and then return the community found by applying the maximum community construction heuristic explained above."""
    return find_community (network, list(friends_number_of_people(network)))

#Question 10:
def find_community_from_person (network, people):
    """This function takes as parameter a network and a person, and returns a maximum community containing this person. 
    For this, we choose a person from the network, we create a community containing just this person, 
    we consider the friends of this person by decreasing order of popularity. For each of these people, 
    if this person is friends with all the members of the community already created, then we add him to the community."""
    person = people #stresses the person not to recall a function several times
    
    if person not in network : 
        return False #returns false if the person is not in the network
    
    #Put the person's friends in descending order 
    friends = order_by_decreasing_popularity(network, network[person]) 
    
    #create the required community
    com = [person]
    i = 0
    while i < len(friends):
        if all_his_friends(network, friends[i], com ) == True: #test if the person in the group is friends with the whole community
            com.append(friends[i])
        i += 1
    return com
 
#Question 12:
def find_max_community(network): 
    """This function takes as parameter a network and applies the maximum community search heuristic given by 
    find_community_from_person for all persons in the network. The function should return the largest community found."""
    pers = list(friends_number_of_people(network))[0] #Choose the most popular person on the network
    return find_community_from_person(network, pers) 