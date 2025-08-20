function lancerDe() {
    return Math.floor(Math.random() * 6) + 1;
    }

let des = [];

for (let i = 1; i < 6; i++) {
    let deActuel = lancerDe();
        des.push(deActuel);
    console.log("Dé " + i + " : " + deActuel);
}