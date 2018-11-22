$(window).on("load", async () => {
	console.log("Loaded");
	let template = $("#codearea").html();
	$("codearea").each((i, area) => {
		let areaRef = $(area);
		let ref = Math.floor(Math.random() * 1000000).toString();
		let rendered = template.replace(/\{code\}/g, areaRef.html().trim());
		rendered = rendered.replace(/\{name\}/g, areaRef.data()["name"]);
		rendered = rendered.replace(/\{ref\}/g, ref);
		areaRef.replaceWith($(rendered));
	});

	$(".code-reset").each((i, reset) => {
		let resetRef = $(reset);
		let ref = resetRef.data()["ref"];
		resetRef.on("click", () => {
			let og = $(`[data-ref="${ref}"].code-original`).text().trim();
			console.log(og);
			console.log($(`[data-ref="${ref}"].code-text`));
			$(`[data-ref="${ref}"].code-text`).val(og);
		})
	});

	$(".code-run").each((i, run) => {
		let runRef = $(run);
		let ref = runRef.data()["ref"];
		runRef.on("click", async () => {
			let code = $(`[data-ref="${ref}"].code-text`).val();
			let result = await fetch("/run", { 
				method: "POST",
				headers: {
					"Content-Type": "application/x-www-form-urlencoded",
				},
				body: `code=${encodeURIComponent(code)}`,
			});
			let data = await result.text();
			$(`[data-ref="${ref}"].code-result`).html(data);
		})
	})
})