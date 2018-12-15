// Simple

let person = {}
person.name = 'Foobar'
person.money = 100

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

person.earn(1000)
person.spend(200)
person.donate(100)
console.log(`💰 of ${person.name}: ${person.money} €`)

// === Output ===
// Foobar earns 1000 €
// Foobar spends 200 €
// Foobar donates 100 € 🙏
// 💰 of Foobar: 800 €
