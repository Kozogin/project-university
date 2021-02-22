$(document).ready(function() {
	
	$("#facultySelect").change(function() {
		var facultyIdSelect = $('#facultySelect').val();
		var request = '';
		var customUrl = '';

		let xhr = new XMLHttpRequest();	
		
		let urlContent = window.location.href.split('/');
		for (var i = 0; i < urlContent.length - 1; i++) {
			customUrl += urlContent[i] + "/";
		}
		
		if(urlContent[urlContent.length - 1] == 'lessons'){
			request = customUrl + 'lessonsScript/' + facultyIdSelect;
		} else{
			request = customUrl + 'gradesScript/' + facultyIdSelect;
		}
		
		xhr.open("GET", request);		
		xhr.setRequestHeader("Content-type", "application/json");		
		xhr.send((facultyIdSelect));
		
	});	
	
});