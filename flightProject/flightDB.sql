drop table ticketTB;
drop table airportTB;

  CREATE TABLE ticketTB  (	
    "TICKET_ID" NUMBER(20,0) primary key, 
	"AIRLINE" VARCHAR2(20 BYTE), 
	"FLIGHT_NAME" VARCHAR2(10 BYTE), 
	"DEPARTURE" VARCHAR2(5 BYTE), 
	"ARRIVE" VARCHAR2(5 BYTE), 
	"DEP_TIME" DATE, 
	"ARRI_TIME" DATE, 
	"SEAT_ABLE" NUMBER(5,0), 
	"SEAT_PRICE" NUMBER(20,0), 
	"DNAME" VARCHAR2(50 BYTE), 
	"ANAME" VARCHAR2(50 BYTE)
   );
   DROP SEQUENCE ticketTB_seq;
   CREATE SEQUENCE ticketTB_seq;
    Insert into SCOTT.TICKETTB (TICKET_ID,AIRLINE,FLIGHT_NAME,DEPARTURE,ARRIVE,DEP_TIME,ARRI_TIME,SEAT_ABLE,SEAT_PRICE,DNAME,ANAME) values (9,'�ƽþƳ��װ�','OZ232','ICN','LAX',to_date('18/09/22','RR/MM/DD'),to_date('18/09/22','RR/MM/DD'),20,1358500,null,null);
    Insert into SCOTT.TICKETTB (TICKET_ID,AIRLINE,FLIGHT_NAME,DEPARTURE,ARRIVE,DEP_TIME,ARRI_TIME,SEAT_ABLE,SEAT_PRICE,DNAME,ANAME) values (8,'�����װ�','KE111','ICN','GUM',to_date('18/09/22','RR/MM/DD'),to_date('18/09/23','RR/MM/DD'),30,476725,null,null);
    Insert into SCOTT.TICKETTB (TICKET_ID,AIRLINE,FLIGHT_NAME,DEPARTURE,ARRIVE,DEP_TIME,ARRI_TIME,SEAT_ABLE,SEAT_PRICE,DNAME,ANAME) values (16,'�����װ�','ke701','ICN','LAX',to_date('18/06/21','RR/MM/DD'),to_date('18/06/22','RR/MM/DD'),5,1358500,'��õ����','�ν������������ͳ��ų�');
  
   CREATE TABLE "AIRPORTTB" (	
	"PORT_COUNTRY" VARCHAR2(40 BYTE), 
	"PORT_CODE" VARCHAR2(5 BYTE), 
	"PORT_NAME" VARCHAR2(50 BYTE)
   );
    Insert into SCOTT.AIRPORTTB (PORT_CONTINENT,PORT_COUNTRY,PORT_CODE,PORT_NAME) values ('asia','South Korea','ICN','��õ����');
    Insert into SCOTT.AIRPORTTB (PORT_CONTINENT,PORT_COUNTRY,PORT_CODE,PORT_NAME) values ('asia','South Korea','GMP','��������');
    Insert into SCOTT.AIRPORTTB (PORT_CONTINENT,PORT_COUNTRY,PORT_CODE,PORT_NAME) values ('america','�̱�','LAX','�ν������������ͳ��ų�');
    Insert into SCOTT.AIRPORTTB (PORT_CONTINENT,PORT_COUNTRY,PORT_CODE,PORT_NAME) values ('america','�̱�','JFK','�����������ɳ׵�');
    Insert into SCOTT.AIRPORTTB (PORT_CONTINENT,PORT_COUNTRY,PORT_CODE,PORT_NAME) values ('america','�̱�','GUM','��');
    Insert into SCOTT.AIRPORTTB (PORT_CONTINENT,PORT_COUNTRY,PORT_CODE,PORT_NAME) values ('america','�����','GIG','�������ڳ��̷����ͳ׼ų�');
    Insert into SCOTT.AIRPORTTB (PORT_CONTINENT,PORT_COUNTRY,PORT_CODE,PORT_NAME) values ('america','�����','DFW','�����Ʈ�������ͳ׼ų�');
    Insert into SCOTT.AIRPORTTB (PORT_CONTINENT,PORT_COUNTRY,PORT_CODE,PORT_NAME) values ('america','�����','FOR','����Ż����');
    
    create table country (
        country_code varchar2(5),
        country_name varchar2(40),
        "CONTINENT" VARCHAR2(20 BYTE) 
    );
    
    create table 
    commit;