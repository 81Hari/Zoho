<h1>Alternate Sorting:</h1> 
Given an array of integers, rearrange the array in such a way that the first element is first maximum and second element is first minimum. <br>
Eg.)<br> 
<b>Input :</b> {1, 2, 3, 4, 5, 6, 7} 

<b>Output : </b>{7, 1, 6, 2, 5, 3, 4} 

<br>
<br>
<h2>Solution- 1</h2>

<ul> 
  <li>creating two copies of the given array, Sorting one of the array in increasing order and other in decreasing order.</li>
  <li>Now traversing through both arrays alternatively,picking the elements respictively and overwriting the original array.</li>
</ul>

<h2>Solution- 2</h2>
<ul>
<li> Creating a copy of given array,sort the that array in increasing order</li>
<li> Now creating two pointers in sorted array, using that pointers traversing the array from the start and from the end,picking elements alternatively from both ends and overwriting the original array.</li> 

</ul>
