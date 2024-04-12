fl4g = "AYAM"
enc = [];
holder1 = [];
holder2 = [];
fl4g.split("").map((char, index) => {
    // index 0 itu ord + 1
    // index setelahnya ord + index sebelumnya
    !index ? holder1[index] = char.charCodeAt(0) + 1 : holder1[index] = ((char.charCodeAt(0) + holder1[index - 1]) % 33554432)
});
holder1.map((ord, index) => {
    // index 0 itu ord
    // index setelahnya itu ord + index sebelumnya
    !index ? holder2[index] = holder1[index] : holder2[index] = (ord + holder1[index - 1]) % 131072
});
//enc itu setengahnya holder1, setengahnya holder2
enc = holder1.concat(holder2);
console.log(enc);
enc.map((wkwk, zz) => {
    enc[zz] = String.fromCharCode(wkwk)
});
enc = enc.join("")