alter table etudiant drop constraint if exists personne_etudiant_fk;
alter table enseignant drop constraint if exists personne_enseignant_fk;
alter table evaluation drop constraint if exists fk_etudiant ;

drop table if exists personne ;
drop table if exists etudiant;
drop table if exists enseignant ;
drop table if exists module ;
drop table if exists evaluation ;


CREATE TABLE personne
( id_personne int,
  nom varchar,
  prenom varchar,
  primary key (id_personne)
);

CREATE TABLE etudiant
( id_etudiant int,
  NIP int,
  primary key (id_etudiant)
);
 

CREATE TABLE enseignant
( id_enseignant int ,
  primary key (id_enseignant)
);

CREATE TABLE module
( id_module int,
  id_enseignant int,
  intitule varchar,
  code varchar,
  unite_enseignant varchar,
  primary key (id_module, id_enseignant)
);

CREATE TABLE evaluation
( id_evaluation int,
  id_etudiant int,
  id_module int,
  nom_eval varchar,
  date_evaluation varchar,
  note float,
  primary key (id_evaluation, id_etudiant)
);



alter table etudiant
add constraint personne_etudiant_fk  
  foreign key (id_etudiant)
  references personne (id_personne);


alter table enseignant
add constraint personne_enseignant_fk
foreign key (id_enseignant)
references personne (id_personne);

alter table evaluation
add constraint fk_etudiant
foreign key (id_etudiant)
references personne (id_personne);


\copy personne FROM personne.txt
\copy etudiant FROM etudiant.txt
\copy enseignant FROM enseignant.txt
\copy module FROM module.txt
\copy evaluation FROM evaluation.txt


--Requetes--
SELECT distinct nom, prenom,intitule
FROM enseignant e,personne, module m
WHERE e.id_enseignant = id_personne and e.id_enseignant=m.id_enseignant;

SELECT distinct personne.nom, prenom,nom_eval,date_evaluation
FROM etudiant et,personne, evaluation e
WHERE et.id_etudiant = id_personne and e.id_etudiant=et.id_etudiant
group by personne.nom, prenom,nom_eval,date_evaluation
having date_evaluation = '20/10/21';

SELECT distinct personne.nom, prenom,AVG(note)
FROM etudiant e,personne, evaluation et
WHERE e.id_etudiant = id_personne and e.id_etudiant= et.id_etudiant
group by personne.nom, prenom,note ;