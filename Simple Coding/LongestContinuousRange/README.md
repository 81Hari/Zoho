<h1>Longest Continuous Range</h1>

Given an array of positive numbers. Print the numbers which have longest continuous range.<br>

<b>INPUT :</b> <br>
Enter array size : 8 <br> 
Enter array elements : 1 3 10 7 9 2 4 6<br> 


<b>OUTPUT :</b> <br>
1 2 3 4<br>

<b>INPUT :</b><br> 
Enter array size : 8 <br>
Enter array elements : 1 3 9 7 8 2 4 6 <br>

<b>OUTPUT :</b> <br>
1 2 3 4 <br>
6 7 8 9 <br>

<h2> SOLUTION </h2>

<ul>
  <li> Sort the given array</li>
  <li> Store all the continuous range of elements in 2D Matrix in seperate row</li>
  <li> In Same While Also Store each size of continuous range of elements in 1D array</li>
  <li> Using the sizeArray, find the size of longest continuous range of elements </li>
  <li>Now print only the row whose size is matching the size of longest continuous range</li>
</ul



