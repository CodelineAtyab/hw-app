let name="Atyab";
console.log("Hey there");

let flag=true;

if(flag){
    console.log("How");
    flag=false;
} else if(true) {
    console.log("In else");
}

console.log(flag, "X", "something");

let myList = [1, 2, 3];

myList = myList.map(
    (elem) => {
        return elem+1;
    }
);

myList.forEach((e) => {
    console.log(e);
}
);

console.log("***");
for(let i=0;i<myList.length;i++){
    console.log(myList[i]);
}

let student = {'name': "Ameer", "email": "asd@asd.com"}
console.log(student.name);
console.log(student.email);

myList.splice()

let myMap = new Map();
myMap.set("name", "Atyab");
myMap.set(2, "2");
myMap.set('status', true);

console.log(myMap.get("name"));
console.log(myMap.get(2));
console.log(myMap.get("status"));

// document.getElementById("greet").innerHTML = document.getElementById("greet").innerHTML.replace("You", "Me");

for (let [k, v] of myMap){
    console.log(k, v);
}

let [a, b] = [1, 2];
console.log(a);
console.log(b);
console.log("\n");

const mySum = (a, b, ...args) => {
    console.log(args);
}

mySum(1,num2=2,3, word="Hello");
