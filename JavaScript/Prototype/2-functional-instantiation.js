// Functional Instantiation

function Person(name, money) {
  let person = {}
  person.name = name
  person.money = money

  person.earn = function(amount) {
    console.log(`${this.name} earns ${amount} €`)
    this.money += amount
  }

  person.spend = function(amount) {
    console.log(`${this.name} spends ${amount} €`)
    this.money -= amount
  }

  person.donate = function(amount) {
    console.log(`${this.name} donates ${amount} € 🙏`)
    this.money -= amount
  }

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

// === Heap Dump (by Chrome DevTools) ===
// Object: foo, Retained Size: 888 bytes
// Object: bar, Retained Size: 888 bytes

// Issues:
// wasting memory and making each Person object bigger,
// due to recreating methods whenever creating a new Person
