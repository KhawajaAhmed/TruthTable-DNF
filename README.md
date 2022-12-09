 # This file contains general comments and information helpful in understanding the code.
***
There are separate methods to define boolean expressions inside __Main.java__. The method that needs to be used depends on the number of _inputs_(unique variables in the boolean expression).

* If there is a boolean expression with two unique variables,please define it inside the myExpression(boolean a,boolean b) method like this:
  
```java
	public static boolean myExpression(boolean a,boolean b)
	{
		return !(a && b);
	}
```

* Two ArrayLists are being used in the code. The first one is a local ArrayList _arr_ which stores the string representation of each variable in each pass through the _for_ loops:
```java
	arr.add(a  ? "a" : "¬a");
	arr.add(b ? "b" : "¬b");
```


* The second is a global ArrayList _list_ which stores individual expressions that generate a "1" inside each pass of the innermost _for_ loop like this:
  
```java
	list.add(arr.get(0) + "∧" + arr.get(1));
```

* The method dnfExpression() uses the global ArrayList _list_ to combine each expression that generated a "1" and combines them to print them in the DNF

