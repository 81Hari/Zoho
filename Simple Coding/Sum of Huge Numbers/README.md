<h1>Sum of Huge Numbers</h1>

Given 2 huge numbers as separate digits, store them in array
and process them and calculate the sum of 2 numbers and store
the result in an array and print the sum.<br>

<b>Input:</b><br>

Number1: 928135673116<br>
Number2: 784621997<br>


<b>Output :</b><br>
9 2 8 9 2 0 2 9 5 1 1 3

<h2>Solution</h2>

<ul>
  <li>Create Two arrays with size of 100</li>
  <li>Now read the first number and second number as String from user</li>
  <li>Traverse the String1(first number) digit by digit from the last and store the each digit in the array from the last</li>
  <li>j = N-1-i</li>
  <li> arr[j] = Integer.parseInt(rawInput.substring(n1-1-i,n1-i))</li>
  <li>Now do the same process for the second number</li>
  <li> Now declare one variable to store remaining (When we add two numbers, if we get two digit number we keep one digit in remaining and add it to next)<li>
  <li>Now add the two arrays elements from the last and store result in third array</li>
  <li> print the third array</li>
</ul>

<pre>
temp = hNum2[N-1-i] + hNum1[N-1-i] +rem; Adding two digits and the remmaining	
result[n3-1-i] = temp%10; storing one digit in the third array
rem = temp/10; And another digit in remaining
</pre>
