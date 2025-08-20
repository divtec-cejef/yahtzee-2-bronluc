function lancerDe() {
    return Math.floor(Math.random() * 6) + 1;
}
const dés = [lancerDe(), lancerDe(), lancerDe(), lancerDe(), lancerDe()];

console.log(dés);