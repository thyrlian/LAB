// Pseudoclassical Instantiation

function Person(name, money) {
  this.name = name
  this.money = money
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

const foo = new Person('Foo', 1000)
const bar = new Person('Bar', 200)
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

// Improvement:
// when invoke a function using the new keyword
// it does several things implicitly
// an object gets created
// and the object gets returned
