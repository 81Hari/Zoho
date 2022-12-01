
<h1>Taxi Reservation</h1>

1.Design a Call taxi booking application<br>
<ul>
  <li>There are n number of taxi’s. For simplicity, assume 4. But it should work for any number of taxi’s.</li>
  <li>The are 6 points(A,B,C,D,E,F)</li>
  <li>All the points are in a straight line, and each point is 15kms away from the adjacent points.</li>
  <li>It takes 60 mins to travel from one point to another</li>
  <li>Each taxi charges Rs.100 minimum for the first 5 kilometers and Rs.10 for the subsequent kilometers.</li>
  <li>For simplicity, time can be entered as absolute time. Eg: 9hrs, 15hrs etc.</li>
  <li>All taxi’s are initially stationed at A.</li>
  <li>When a customer books a Taxi, a free taxi at that point is allocated</li>
  <li>If no free taxi is available at that point, a free taxi at the nearest point is allocated.</li>
  <li>If two taxi’s are free at the same point, one with lower earning is allocated</li>
  <li>Note that the taxi only charges the customer from the pickup point to the drop point. Not the distance it travels from an adjacent point to pickup the customer.</li>
  <li>If no taxi is free at that time, booking is rejected</li>
</ul>

<pre>
1)    Call taxi booking 
Input 1:
Customer ID: 1
Pickup Point: A
Drop Point: B
Pickup Time: 9

Output 1:
Taxi can be allotted.
Taxi-1 is allotted

Input 2:
Customer ID: 2
Pickup Point: B
Drop Point: D
Pickup Time: 9

Output 2:
Taxi can be allotted.
Taxi-2 is allotted 

Input 3:
Customer ID: 3
Pickup Point: B
Drop Point: C
Pickup Time: 12

Output 3:
Taxi can be allotted.
Taxi-1 is allotted 
</pre>

<pre>
Taxi No:    Total Earnings:
BookingID    CustomerID    From    To    PickupTime    DropTime    Amount
   
Output:
Taxi-1    Total Earnings: Rs. 400

1     1     A    B    9    10    200
3    3    B    C    12    13    200

Taxi-2 Total Earnings: Rs. 350
2    2    B    D    9    11    350 
</pre>

