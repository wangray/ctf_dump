mov rdi, 0x414100000000
mov rsi, 0x1000
mov rdx, 6
mov r10, 0x32
mov r8, -1
mov r9, 0
mov rax, 9
syscall

start:

mov rdi, r11
mov rsi, 0x414100000000
mov rdx, 0x1000
mov rax, 0
syscall

mov rdi, r11
mov rsi, 0x414100000000
mov rdx, 0x1000
mov rax, 1
syscall

add r11, 1
jmp start
