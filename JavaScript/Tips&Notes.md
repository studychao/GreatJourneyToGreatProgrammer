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

### JavaScript Wait time command
```
function stateChange(newState) {
    setTimeout(function () {				//This is for time out.
        if (newState == -1) {
            alert('VIDEO HAS STOPPED');
        }
    }, 5000);
}
```

### JavaScript Write Files
```
/**
 * filename, 必选参数，文件名
 * data, 写入的数据，可以字符或一个Buffer对象
 * [options],flag,mode(权限),encoding
 * callback 读取文件后的回调函数，参数默认第一个err,第二个data 数据
 */

fs.writeFile(__dirname + '/test.txt', w_data, {flag: 'a'}, function (err) {
   if(err) {
    console.error(err);
    } else {
       console.log('写入成功');
    }
});
```
- File System Flags
'a' - Open file for appending. The file is created if it does not exist.
'w' - Open file for writing. The file is created (if it does not exist) or truncated (if it exists).


### How to get out of RawPacketData?
```
var string=JSON.stringify(rows);
      var data = JSON.parse(string)
      maxid = data[0].maxid;
```


### Javascript String -> JSON 
JSON.stringify(obj) JSON -> STRING
JSON.parse(string)  STRING -> JSON