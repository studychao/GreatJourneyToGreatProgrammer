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

### dotenv package 
get the environment variable

### Module
- What is a module?
A module encapsulates related code into a single unit of code. When creating a module, this can be interpreted as moving all related functions into a file
```
// greetings.js
sayHelloInEnglish = function() {
return "Hello";
};

sayHelloInSpanish = function() {
return "Hola";
};
```
- Exporting a Module
The utility of `greeting.js` increases when its encapsulated code can be utilized in other files.Let's refactor `greeting.js`.

1. Imagine that this line of code exists as the first line of code in `greeting.js`
```
var exports = module.exports = {};
```

2. Assign any expression in `greetings.js` that we want to become available in other files to the exports `objects` object:
```
// greetings.js
// var exports = module.exports = {};

exports.sayHelloInEnglish = function() {
return "HELLO";
};

exports.sayHelloInSpanish = function() {
return "Hola";
};
```
In the code above, we could have replaced `exports` with `module.exports` and achieved the same result. If this seems confusing, remember that `exports` and `module.exports` reference the same object.

3. This is the current value of module.exports:
```
module.exports = {
sayHelloInEnglish: function() {
return "HELLO";
},

sayHelloInSpanish: function() {
return "Hola";
}
};
```

- Importing a Module
Let's import the publicly available methods of `greeting.js` to a new file called `main.js`.
1. The keyword `require` is used in Node.js to import modules.Imagine that this is how require is defined.
```
var require = function(path) {

// ...

return module.exports;
};
```

2. Let's require `greeting.js` in `main.js`:
```
// main.js
var greetings = require("./greetings.js");
```
This is equivalent to 
```
// main.js
var greetings = {
sayHelloInEnglish: function() {
return "HELLO";
},

sayHelloInSpanish: function() {
return "Hola";
}
};
```

3. Now we can use those functions freely
```
// main.js
var greetings = require("./greetings.js");

// "Hello"
greetings.sayHelloInEnglish();

// "Hola"
greetings.sayHelloInSpanish();
```

- Important Points

### "Use Strict"
The purpose of "use strict" is to indicate that the code should be executed in "strict mode".

With strict mode, you can not, for example, use undeclared variables.