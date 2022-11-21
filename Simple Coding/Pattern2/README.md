<h1>Pascal Triangle</h1>

Print the following pattern<br>
<b>INPUT :</b> 5<br>

<pre>
    1 
   1 1 
  1 2 1 
 1 3 3 1 
1 4 6 4 1 
</pre>

<b>INPUT :</b> 7<br>
<pre>
      1 
     1 1 
    1 2 1 
   1 3 3 1 
  1 4 6 4 1 
 1 5 10 10 5 1 
1 6 15 20 15 6 1
</pre>

<h2>Solution</h2>
<ul>
    <li>create Matrix with size NxN</li>
    <li>First and last element  of each row is 1</li>
    <li>elements b/w first and last are sum of adjacent elements of previous row</li>
    <li> print the matrix in triangle pattern</li>
</ul>
