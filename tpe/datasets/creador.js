const fs = require("fs");
let data = "";
for (let i = 1; i <= 15000; i++) {
  const random = Math.floor(Math.random() * (30 - 3)) + 3;
  data += `T${i};Tarea${i};${i * random};${i % 2 == 0 ? "true" : "false"};${
    58 + i
  };\n`;
}
fs.writeFileSync("tpe/datasets/TareasExtended.csv", data);

array.forEach((element) => {});
