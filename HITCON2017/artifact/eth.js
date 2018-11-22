var rpc = require("ethrpc");
var connectionConfiguration = {
  httpAddresses: ["http://something.420blaze.in:8545"], // optional, default empty array
  wsAddresses: [], // optional, default empty array
  ipcAddresses: [], // optional, default empty array
  networkID: 3, // optional, used to verify connection to the intended network (blockchain)
  connectionTimeout: 3000, // optional, default 3000
  errorHandler: function (err) { /* out-of-band error */ }, // optional, used for errors that can't be correlated back to a request
};
rpc.connect(connectionConfiguration, function (err) {
  if (err) {
    console.error("Failed to connect to Ethereum node.");
  } else {
    console.log("Connected to Ethereum node!");
  }
});


var contractCode = rpc.eth.getCode("0x86fb6d1f1bd78cc13c6354b6436b6ea0c144de2e");
console.log(contractCode)