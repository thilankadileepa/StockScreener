var JSON_SUCESS = 1;
var JSON_ERROR = -1;

/**
 * Ajax method
 * 
 * @param url
 * @param param
 * @param callBack
 * @param divId
 * @param type
 *            Data type. html or json or any
 * @param method
 *            GET or POST
 */
function doAjax(url, param, callBack, divId, type, method, extraData) {
	if (!type) {
		type = "GET";
	}
	if (!type) {
		type = "html";
	}
	$.ajax({
		url : url,
		data : param,
		dataType : type,
		type : method,
		success : function(data) {
			callBack(data, divId, extraData, param);
		},
		error : function() {

		}
	});
}

function replaceExisiting(data, divId) {
	$("#" + divId).html(data);
}

function isEmpty(obj) {
	if (!obj) {
		return false;
	}
	if (obj.length == 0 || obj === "") {
		return false;
	}
	return true;
}

function isObjEmpty(obj) {
	if (!obj) {
		return true;
	}
	if (obj.length == 0 || obj === "") {
		return true;
	}
	return false;
}

 
function displayCommonError(header, msg){
	if(header){
		$("#errorHeader").html(header);
	}
	if(msg){
		$("#errorMsg").html(msg);
	}
	$.blockUI({ message: $('#commonError') });
}

function clear(element)
{
	element.val("");
}

function blockInMiddle(id){
	
	$.blockUI({ 
		message: $('#'+ id),
		top: 30 + "%"
		});
}

function replaceAll(string, replace, replaceWith){
	if(string){
		while(string.indexOf(replace) > -1){
			string = string.replace(replace, replaceWith);
		}
	}
}

function initDatePicker(range, from, to) {

	var dates = $(range)
			.datepicker(
					{
						numberOfMonths : 2,
						/*minDate : 0,*/
						onSelect : function(selectedDate) {
							var option = this.id == from ? "minDate"
									: "maxDate", instance = $(this).data(
									"datepicker"), date = $.datepicker
									.parseDate(
											instance.settings.dateFormat
													|| $.datepicker._defaults.dateFormat,
											selectedDate, instance.settings);

							date.setDate(date.getDate() + 1);
							dates.not(this).datepicker("option", option, date	);
						}
					});
}
