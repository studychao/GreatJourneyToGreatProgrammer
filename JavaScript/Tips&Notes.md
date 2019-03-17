##JavaScript Tips&Notes

### str replace替换全部
```
var str = "test-test-test";
str = "test-test-test".replace(/test/g, "ok");
console.log(str);
```

### hightlight after ajax
```
$('pre > code').each(function() {
     hljs.highlightBlock(this);
});
```