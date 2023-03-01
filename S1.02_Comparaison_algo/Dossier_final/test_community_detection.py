from community_detection import *

#Question 1: 
def test_create_network() :
    """Unit test function of the create_network function"""
    
    dic = create_network(friends)
    assert len(list(dic)) < len(friends)
    i = 0
    while i <len(list(dic.values())) : 
        y = 0
        while y < len(list(dic.values())[i]) :
            assert len(list(dic.values())[i][y]) > 0
            y += 1
        i += 1
    assert create_network(friends)== {'Alice': ['Bob', 'Dominique'], 'Bob': ['Alice', 'Charlie', 'Dominique'], 'Charlie': ['Bob'], 'Dominique': ['Alice', 'Bob']}
    print('\nUnit tests of the function create_network : ok')

#Question 3: 
def test_get_people():
    """Unit test function of the get_people function"""
    dic = create_network(friends)
    assert get_people(dic) == ["Alice", "Bob", "Charlie", "Dominique"]
    assert not get_people(dic) == ["Alice","Charlie", "Dominique"]
    print('\nUnit tests of the function get_people : ok')

#Question 4: 
def test_are_friend():
    """Unit test function of the are_friend function"""
    dic = create_network(friends)
    assert are_friend(dic ,"Alice","Bob") == True 
    assert are_friend(dic ,"Alice","Charlie") == False
    assert are_friend(dic ,"Bob","Dominique") == True
    assert are_friend(dic ,"Charlie","Alice") == False
    print('\nUnit tests of the function are_friend : ok')

#Question 5:
def test_all_his_friends():
    """Unit test function of the all_his_friends function"""
    dic = create_network(friends)
    assert all_his_friends(dic, "Alice", ["Bob", "Dominique"]) == True 
    assert all_his_friends(dic, "Alice", ["Bob", "Charlie"]) == False 
    assert all_his_friends(dic, "Charlie", ["Bob"]) == True
    print('\nUnit tests of the function all_his_friends : ok')

#Question 6:
def test_is_a_community():
    """Unit test function of the is_a_community function"""
    dic = create_network(friends)
    assert is_a_community(dic, ["Alice", "Bob", "Dominique"]) == True 
    assert is_a_community(dic, ["Alice", "Bob", "Charlie"]) == False 
    assert is_a_community(dic, ["Alice", "Bob", "Dominique", "Charlie"]) == False
    print('\nUnit tests of the function is_a_community : ok')

#Question 7:
def test_order_by_decreasing_popularity():
    dic = create_network(friends)
    assert order_by_decreasing_popularity(dic, ["Dominique", "Alice", "Bob"])== ['Bob', 'Dominique', 'Alice']
    assert order_by_decreasing_popularity(dic, ["Charlie", "Dominique", "Bob"])== ['Bob', 'Dominique', 'Charlie']
    assert order_by_decreasing_popularity(dic, ["Bob", "Alice", "Charlie"])== ['Bob', 'Alice', 'Charlie'] 
    assert order_by_decreasing_popularity(dic, ["Bob", "Alice", "Charlie", 'Dominique'])== ['Bob', 'Dominique','Alice', 'Charlie']


    print('\nUnit tests of the function order_by_decreasing_popularity : ok')
#Question 8:
def test_order_by_decreasing_popularity():
    dic = create_network(friends)
    assert order_by_decreasing_popularity(dic, ["Dominique", "Alice", "Bob"])== ['Bob', 'Dominique', 'Alice']
    assert order_by_decreasing_popularity(dic, ["Charlie", "Dominique", "Bob"])== ['Bob', 'Dominique', 'Charlie']
    assert order_by_decreasing_popularity(dic, ["Bob", "Alice", "Charlie"])== ['Bob', 'Alice', 'Charlie'] 
    assert order_by_decreasing_popularity(dic, ["Bob", "Alice", "Charlie", 'Dominique'])== ['Bob', 'Dominique','Alice', 'Charlie']


    print('\nUnit tests of the function order_by_decreasing_popularity : ok')
#Question 9:
def test_find_community_by_decreasing_popularity():
    dic = create_network(friends)
    assert find_community_by_decreasing_popularity(dic)== ['Bob', 'Dominique', 'Alice']
    assert not find_community_by_decreasing_popularity(dic)== ['Charlie', 'Dominique', 'Alice']

    print('\nUnit tests of the function find_community_by_decreasing_popularity : ok')

#Question 10:
def test_find_community_from_person():
    dic = create_network(friends)
    assert find_community_from_person(dic, "Alice")== ['Alice', 'Bob', 'Dominique']
    assert find_community_from_person(dic, "Bob")== ['Bob', 'Dominique', 'Alice']
    assert find_community_from_person(dic, "Charlie")== ['Charlie', 'Bob']

    print('\nUnit tests of the function test_find_community_from_person : ok')
 
#Question 12:
def test_find_max_community():
    dic = create_network(friends)
    assert find_max_community(dic)== ['Bob', 'Dominique', 'Alice']
    assert not find_max_community(dic)== ['Charlie', 'Dominique', 'Alice']

    print('\nUnit tests of the function test_find_max_community : ok')