do $$
DECLARE
   noOfRecords INT:=1000;
   startTime timestamp:= now();
   typeArray text[]:='{"Health","Banking","Transport","Food"}';
   modVal INT:=0;
   empid INT :=0;
   endTime timestamp:= now();
BEGIN
FOR i IN 1..noOfRecords LOOP
 modVal=mod(i,4);
 empid = floor(random()*100+3);
 if modVal=0 THEN
 modVal=4;
 end if;
 startTime=date (timestamp '2022-01-01' + random() * (timestamp '2022-11-30' - timestamp '2022-01-01')) + time '10:00:00' + random() * INTERVAL '8 hours';
 endTime = startTime + time '01:00:00' + random() * INTERVAL '1 hours';
 insert into "Request"("ReqId","ClientId","EmpId","StartTime","EndTime","Category","Status") values(i,i*2,empid,startTime,endTime,modVal,'Resolved');
  end loop;
END
$$;