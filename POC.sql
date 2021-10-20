CREATE TABLE bank.Users (
	Userid int NOT NULL AUTO_INCREMENT,
    PersonID int NOT NULL,
    Username varchar(255) NOT NULL ,
    PassWord  varchar(255) NOT NULL,
    SecurityQuestion varchar(255) ,
    SecurityAnswer varchar(255) ,
    Role varchar(255)  NOT NULL,
      CHECK (Role='MANAGER'OR Role='CUSTOMER'),
      PRIMARY KEY (Userid),
    FOREIGN KEY (PersonID) REFERENCES Persons(PersonID)
    );
    
CREATE TABLE bank.Persons (
    PersonID int  NOT NULL AUTO_INCREMENT,
    PersonName varchar(255) NOT NULL,
    Gender varchar(255) NOT NULL,
    EmailID varchar(255) NOT NULL, 
    DateOFBirth date NOT NULL,
    MobileNumber int NOT NULL ,
    AddressID int NOT NULL,
     UNIQUE(EmailID),
      UNIQUE(MobileNumber),
       CHECK (Gender='MALE'OR Gender='FEMALE'),
     PRIMARY KEY (PersonID),
      FOREIGN KEY (AddressID) REFERENCES Address(AddressID)
);

Create Table bank.Address
(
  AddressID int  NOT NULL AUTO_INCREMENT,
  State  Varchar(255),
  City varchar(255) NOT NULL,
  Area varchar(255) NOT NULL,
  DoorNumber int NOT NULL,
  PinNumber int NOT NULL,
  PRIMARY KEY (AddressID)
  );
  
Create Table bank.Branch
(
  BranchID int  NOT NULL AUTO_INCREMENT,
  BranchName  Varchar(255) NOT NULL,
  IFSC_CODE varchar(255) NOT NULL,
  MCR_CODE varchar(255) NOT NULL,  
  AddressID int NOT NULL,
  PRIMARY KEY (BranchID),
  FOREIGN KEY (AddressID) REFERENCES Address(AddressID)
  );
  create Table bank.Account(
  AccountID int NOT NULL AUTO_INCREMENT,
  AccountNumber integer NOT NULL ,
  AccoutType  Varchar(255) NOT NULL,
  Balance  float NOT NULL,
  PersonID int NOT NULL,
  BranchID int NOT NULL,
  Transactionlimit int,
   Minimumbalance float,
   Transactionamoutlimit float,
   InterestRate int Not NULL,
   CHECK (AccoutType='CURRENT'OR AccoutType='SAVINGS'),
   PRIMARY KEY (AccountID),
     FOREIGN KEY (PersonID) REFERENCES Persons(PersonID),
     FOREIGN KEY (BranchID) REFERENCES Branch(BranchID)
  );
  
  create Table bank.Transaction
  (
  TransactionID int NOT NULL AUTO_INCREMENT,
  Transaction_Type varchar(255) NOT NULL,
  Transaction_Date_Time datetime,
  TransactionAmount float ,
   AccountID int NOT NULL,
    CHECK (Transaction_Type='TRANSFER'OR Transaction_Type='WITHDRAW' OR Transaction_Type='DEPOSIT'),
   PRIMARY KEY (TransactionID),
     FOREIGN KEY (AccountID) REFERENCES Account(AccountID)
  );
  
  insert into persons values(default,'chirag','MALE','chirag1998.cg@gmail.com','1998-04-24',12345);
  insert into users values(1,'chirag24','abc@123','name of pet','rex','CUSTOMER');
  insert into Address values(default,'Maharashtra','Mumbai','Malad',10,400097,1);
  insert into Branch values(default,'icici','ICIC0141','997913',1,1);
  insert into Account values(default,12345,'SAVINGS',100.0,1,1);
  insert into Transaction values(default,'DEPOSIT','2021-10-12 05:33:10',50.0,1);