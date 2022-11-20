<h1>Pattern Printing</h1>

Write a program to print the following output for the given input. You can assume the string is of odd length<br>

<b>Input: </b> PROGRAM

<b>Output</b>
<pre>
P                 M  
   R           A     
      O     R        
         G           
      O     R        
   R           A     
P                 M  
</pre>

<h2>Solution</h2>

<ul>
<li>Creating Matrix of NxN (where N=length of string)</li>
<li> store the left diagonal of the matrix with the given string</li>
<li> store the right diagonal of the matrix with the given string reversed</li>
</ul>
