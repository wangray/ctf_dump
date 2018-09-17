tacOS.bin: stage-1.asm stage-2.bin
	$(eval num_sectors := $(shell BLOCKSIZE=512 du stage-2.bin | cut -f1))
	#dd bs=512        if=stage-1.bin of=tacOS.bin
	dd bs=512 seek=1 if=stage-2.bin of=tacOS.bin

run: tacOS.bin
	$(eval num_kb := $(shell du -k tacOS.bin | cut -f1))
	@echo "Binary is $(num_kb) KB long"
	qemu-system-x86_64 -serial stdio -d guest_errors -drive format=raw,file=tacOS.bin

clean:
	rm -rf stage-1.bin tacOS.bin
