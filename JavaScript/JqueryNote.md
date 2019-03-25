##Jquery Tips&Notes

### Selector
1. $("p") -> <p>
2. $(".intro") -> class = "intro"
3. $("#demo") -> id = "demo" 

### text()
Get the combined text contents of each element in the set of matched elements, including their descendants.
```
<div class="demo-container">
  <div class="demo-box">Demonstration Box</div>
  <ul>
    <li>list item 1</li>
    <li>list <strong>item</strong> 2</li>
  </ul>
</div>
```
The code `$( "div.demo-container" ).text()` would produce the following result:
`Demonstration Box list item 1 list item 2`

### toggleClass()
`$( "#foo" ).toggleClass( className, addOrRemove );`

### attr()

### add()

### position()
position()获取相对于它最近的具有相对位置(position:relative或position:absolute)的父级元素的距离

### offset()

### Scrolltop()
Get the current vertical position of the scroll bar for the first element in the set of matched elements or set the vertical position of the scroll bar for every matched element.