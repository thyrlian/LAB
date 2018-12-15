// Functional Instantiation with Shared Methods and Object.create

const personMethods = {
  earn(amount) {
    console.log(`${this.name} earns ${amount} €`)
    this.money += amount
  },
  spend(amount) {
    console.log(`${this.name} spends ${amount} €`)
    this.money -= amount
  },
  donate(amount) {
    console.log(`${this.name} donates ${amount} € 🙏`)
    this.money -= amount
  }
}

function Person(name, money) {
  let person = Object.create(personMethods)
  person.name = name
  person.money = money
  return person
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

// Improvement:
// Object.create allows you to create an object which will delegate to another object on failed lookups
// instead of adding all the shared methods to the Person one by one
// use Object.create to delegate to the personMethods object instead
// when calling foo.earn, JavaScript will look for the earn method on the foo object, where the lookup will fail,
// then it’ll delegate to the personMethods object where it’ll find earn.
