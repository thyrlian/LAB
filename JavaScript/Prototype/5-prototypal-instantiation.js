// Prototypal Instantiation

function Person(name, money) {
  let person = Object.create(Person.prototype)
  person.name = name
  person.money = money
  return person
}

Person.prototype.earn = function(amount) {
  console.log(`${this.name} earns ${amount} €`)
  this.money += amount
}

Person.prototype.spend = function(amount) {
  console.log(`${this.name} spends ${amount} €`)
  this.money -= amount
}

Person.prototype.donate = function(amount) {
  console.log(`${this.name} donates ${amount} € 🙏`)
  this.money -= amount
}

const foo = Person('Foo', 1000)
const bar = Person('Bar', 200)
foo.earn(2000)
foo.spend(500)
foo.donate(300)
console.log(`💰 of ${foo.name}: ${foo.money} €`)
bar.earn(600)
bar.spend(100)
bar.donate(100)
console.log(`💰 of ${bar.name}: ${bar.money} €`)

// === Output ===
// Foo earns 2000 €
// Foo spends 500 €
// Foo donates 300 € 🙏
// 💰 of Foo: 2200 €
// Bar earns 600 €
// Bar spends 100 €
// Bar donates 100 € 🙏
// 💰 of Bar: 600 €

// every function in JavaScript has a prototype property
// prototype is a property on a function, that points to a object
// function func() {}
// console.log(func) //=> [Function: func]
// console.log(func.prototype) //=> func {}
// console.log(typeof func.prototype); //=> object

// Improvement:
// instead of creating a separate object to manage methods (like personMethods)
// put each of those methods on the Person function’s built-in prototype
// it allows us to share methods across all instances of a function
