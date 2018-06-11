from ethjsonrpc import EthJsonRpc  # to use Parity-specific methods, import ParityEthJsonRpc
>>> c = EthJsonRpc('127.0.0.1', 8545)
>>> c.net_version()