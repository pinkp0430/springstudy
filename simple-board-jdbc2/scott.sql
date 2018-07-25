
CREATE table mvc_board(

   bId NUMBER(4) PRIMARY KEY,

   bName VARCHAR2(20),

   bTitle VARCHAR2(100),

   bContent VARCHAR2(300),

   bDate DATE DEFAULT SYSDATE,

   bHit NUMBER(4) DEFAULT 0,

   bGroup NUMBER(4),

   bStep NUMBER(4),

   bIndent NUMBER(4)

   );

DROP SEQUENCE mvc_board_seq;
CREATE SEQUENCE mvc_board_seq;

INSERT INTO mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, 'Jane', 'I have a Dream', 'Dreams ...', 0, mvc_board_seq.currval, 0, 0);

INSERT INTO mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, 'Joy', 'Happy man', 'I am happy...', 0, mvc_board_seq.currval, 0, 0);
