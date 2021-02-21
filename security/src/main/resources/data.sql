--------------------------------------------------------------------
INSERT INTO users (username, password, enabled)
  values ('user',
    '$2a$10$5fnnLneq.dyqIqZN9kUXDe.qPjZVWrz.kU04wzQdcYaCFaOmspr5y',
    1);
    
INSERT INTO users (username, password, enabled)
  values ('admin',
    '$2a$10$y7oh/DfkyPgOIqLkbgYJouFThzYZ1173qWsq8yRiot3ay.QstZB9S',
    1);
    
---------------------------------------------------------------------
 
INSERT INTO authorities (username, authority)
  values ('user', 'ROLE_USER');
  
INSERT INTO authorities (username, authority)
 values ('admin', 'ROLE_ADMIN');
 
 INSERT INTO authorities (username, authority)
 values ('admin', 'ROLE_USER'); 
 
 