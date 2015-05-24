CREATE PROCEDURE PSELPARAMETRIZACAO(in idUser bigint, OUT tpUser varchar(4)) 
BEGIN  
  SELECT USER_TYPE INTO tpUser FROM User where id = idUser;
END