function handleLoginRequest(xhr, status, args) {
	if (args.validationFailed || !args.loggedIn) {
		PF('loginDlg').jq.effect("shake", {
			times : 5
		}, 100);
	} else {
		location.href = "/hiperion_web/pages/hiperion.jsf";
	}
}

function checkSubmit() {
	// alert(document.getElementById("loginForm\:loginButton").attributes.);
	// alert(loginButtonW.text);
	PF('loginButtonW').disable();
}