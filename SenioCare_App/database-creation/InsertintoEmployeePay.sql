do $$
DECLARE
   noOfRecords INT:=1000;
   random_Hours INT:=0;
   random_Pay INT:=0;
BEGIN
FOR i IN 1..noOfRecords LOOP
 random_Hours = floor(random() * 500 + 100);
 random_Pay = floor(random()*35 + 10);
 insert into "EmployeePay"("PayId","EmpId","TotalWorkingHours","HourlyPay","TotalPay") values(i,i,random_Hours, random_Pay, random_Hours*random_Pay);
  end loop;
END
$$;