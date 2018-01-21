 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      <c:set var ="fullname" value ="${user.firstName} ${user.lastName}"/>   
          <div class="">
            <div class="page-title">
              <div class="title_left">
              <div class="col-md-12">
              </div>
                <h3>Create Weighment</h3>
              </div>
              
            </div>
            
            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  
          <form class="form-horizontal pd15 createweihment-form" method="POST" name="createform" id="formwieghment" >
              <div class="tb-header">
               <div class="col-md-2 col-sm-3 hidden-xs">
               <div class="jme-logo">
               <img src="static/img/logo.png">
               </div>
               </div>
               <div class="col-md-8 col-sm-6 col-xs-12">
               
               <h1 class="text-center mb-font18 heading-blue">JAGADEESH MARINE EXPORTS</h1>
               <div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8 col-xs-12">
               <select class="form-control margin-top-50" id="plantsId" name="plantsId">
                   <option value="0">Select your Weighment Slip</option>
                   <c:forEach var="plant" items="${plantList}">
                   <option value="${plant.billPlantId}">Weighment Slip at ${plant.billPlantName}</option>
                 
                    </c:forEach>
               </select>
              </div>
             
               </div>
               <div class="col-md-2 col-sm-3 col-xs-12">
               <div class="header-right-chk">
              
              <div class="checkbox checkbox-success checkbox-inline">
                        <input type="checkbox" class="styled" id="billVim" value="false" >
                        <label for="inlineCheckbox2"> VIM </label>
                    </div>
                    <br>

                    <div class="checkbox checkbox-success checkbox-inline">
                        <input type="checkbox" class="styled" id="billBt" value="false" >
                        <label for="inlineCheckbox2"> BT </label>
                    </div>
             
         
             </div>
               </div>
               
               </div>
               
<div class="clearfix"></div>

                 <div class="margin-top-100 mb-margin-top-30 col-md-12">
                   <div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Cheque Name :</label>
                     <input type="text" class="form-control" id="chequeue_text" name="chequeue_text">
                   </div>
                   </div>
                   <div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Date :</label>
                     <input type="text" class="form-control" id="weighment_date" name="weighment_date">
                   </div>
                   </div>
                   <div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Name of the Farmer :</label>
                     <input type="text" class="form-control" id="weighment_farmer" name="weighment_farmer">
                   </div>
                   </div>
                   <div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Farmer PhNo:</label>
                     <input type="text" class="form-control" id="weighment_farmer_mob" name="weighment_farmer_mob">
                   </div>
                   </div>
                   <div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Agent Name :</label>
                     <input type="text" class="form-control" id="weighment_agent" name="weighment_agent">
                   </div>
                   </div>
                   <div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Agent PhNo :</label>
                     <input type="text" class="form-control" id="weighment_agent_phno" name="weighment_agent_phno">
                   </div>
                   </div>
                   <div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Place :</label>
                     <input type="text" class="form-control" id="weighment_place" name="weighment_place">
                   </div>
                   </div>
                   <div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Lot No :</label>
                     <input type="text" class="form-control" id="weighment_lotNo" name="weighment_lotNo" readonly="readonly">
                   </div>
                   </div>
                   
                   <div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Truck no :</label>
                     <input type="text" class="form-control" id="truck_no" name="truck_no">
                   </div>
                   </div>
                   
                   <div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Driver :</label>
                     <input type="text" class="form-control" id="driver_name" name="driver_name">
                   </div>
                   </div>
                   
                   <div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Dispatched :</label><br>

                   <div class="checkbox checkbox-success checkbox-inline">
                        <input type="checkbox" class="styled" id="billDispatchedBvrm" value="false" >
                        <label for="inlineCheckbox2"> BVRM </label>
                    </div>
                    <div class="checkbox checkbox-success checkbox-inline">
                        <input type="checkbox" class="styled" id="billDispatchedNsp" value="false" >
                        <label for="inlineCheckbox2"> NSP </label>
                    </div>
                   </div>
                   </div>
                   <div class="clearfix"></div>
                   
                   <div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Dipatch Time :</label>
                     <input type="text" class="form-control time some_class" id="dispatch_time" name="dispatch_time">
                   </div>
                   </div>
                   
                   <div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Arrival Time :</label>
                     <input type="text" class="form-control time some_class" id="arrival_time" name="arrival_time">
                   </div>
                   </div>
                   
                   <div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Ice Qty :</label>
                     <input type="text" class="form-control" id="ice_qty" name="ice_qty" placeholder="In Boxes" onblur="CalMaterialTubs()">
                   </div>
                   </div>
               	<div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Single Net Weight :</label>
                     <select class="form-control"  id="netWeight" onchange="calculateSum()">
					 <option value="selectone">Select One</option>
					 <option value="1.6">1.6 kg</option>
					 <option value="1.7">1.7 kg</option>
					 <option value="1.8">1.8 kg</option>
					  <option value="1.9">1.9 kg</option>
					  <option value="2.0">2.0 kg</option>
					 </select>
                   </div>
                   </div>
                   <div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Total Tubs :</label>
					<input type="text" class="form-control" id="total_tubs" name="total_tubs" placeholder="Total Tubs" readonly>
                   </div>
                   </div>
				      <div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Empty Tubs :</label>
                     <input type="text" class="form-control" id="empty_tubs" name="empty_tubs" placeholder="Empty Tubs"  onblur="CalMaterialTubs()">
                   </div>
                   </div>
               <div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Material Tubs :</label>
                   <input type="text" class="form-control" id="material_tub" name="material_tub" placeholder="Material Tubs" onblur="CalMaterialTubs()">
                   </div>
                   </div>
				       <div class="col-md-4 col-sm-4">
                   <div class="form-group">
                   <label>Remaining Tubs :</label>
                   <input type="text" class="form-control" id="remaining_tubs" name="remaining_tubs" placeholder="Remaining Tubs"  readonly>
                   </div>
                   </div>
               </div>
             
             <div class="clearfix"></div>
             <div class="col-md-12">
              <div class="add_rows col-md-6 col-sm-9" style="border:1px solid #ccc; padding:15px 0px 0px;">
			 <div class="col-md-3 col-sm-3">
			    <div class="form-group">
				  <input type="text" class="form-control" id="fromRow" name="" placeholder="From" data-role="none"/>
				</div>
			   </div>
			   
			   <div class="col-md-3 col-sm-3">
			    <div class="form-group">
				  <input type="text" class="form-control" id="toRow" name="" placeholder="To" data-role="none"/>
				</div>
			   </div>
			   
			   <div class="col-md-3 col-sm-3">
			    <div class="form-group">
				  <input type="text" class="form-control" id="addRowCount" name="" placeholder="Count" data-role="none"/>
				</div>
			   </div>
			   
			   <div class="col-md-3 col-sm-3">
			    <a href="#addRowsByFromTo" class="btn btn-primary no-radius" data-role="none" style="line-height:48px;display:inline;">+Add</a>
			   </div>
			   </div>
               <table class="table table-bordered margin-top-50" id="customFields">
                 <thead class="table-headings">
                   <tr>
                     <th id="billedCreId">SI.No</th>
                     <th id="billedBillCount">Count</th>
                     <th id="billedWgtKgs">Weight in KGS</th>
                     <th id="billedNoOfNets">No.of Nets</th>
                   </tr>
                 </thead>
                 
                 <tbody>
                   <tr id="rowId">
                    <td><input type="text" class="form-control" id="billedCreId" name="slno" value="1" ></td>
                       <td><input type="text" class="form-control" id="count0" name="count" onblur="calculateSum()"> </td>
                        <td><input type="text" class="form-control" id="weight0" name="weight" onblur="calculateSum()"></td>
                         <td><input type="text" class="form-control" id="nets0" name="nets" onblur="calculateSum()"></td>
                   </tr>
                 </tbody>
                         <tfoot>
                    <tr>
                      <td></td>
                       <td><!--  <label><strong>Total Count</strong></label>
                       <input type="text" class="form-control" id="totalCount" name="totalCount">-->
                       </td>
                        <td><label><strong>Total Weight</strong></label><input type="text" class="form-control" id="totalWeight" name="totalWeight"></td>
                         <td><label><strong>Total No.of Nets</strong></label><input type="text" class="form-control" id="totalNets" name="totalNets"></td>
                         
                    </tr>
                    </tfoot>
               </table>
               
              
             </div>
     <a class="add_field_button btn btn-success mb-btn addCF" id="add" >+Add More</a>
     
         <div class="clearfix"></div>
	 <table class="table table-bordered margin-top-50" id="addVarietyTab">
	 <tbody>
 <tr>
	   <td><input type="text" class="form-control" id="" name="" readonly value="1"></td>
	     <td class="billedVarietyName"><select class="form-control" id="billedVarietyName">
   <option value="Select Variety">--Select Variety--</option>
   <option value="Peeling">Peeling</option>
   <option value="Discoloured">Discoloured</option>
   <option value="Black Spot">Black Spot</option>
   <option value="Normal">Normal</option>
 </select></td>
 
 <td class="billedBillVarietyCount"><input type="text" class="form-control" id="" name="" placeholder="Count"></td>
 <td class="billedVarietyWgtKgs"><input type="text" class="form-control" id="" name="" placeholder="Weight"></td>
 <!--<td><input type="text" class="form-control" id="" name=""></td>-->
	   </tr>

	   </tbody>
	 </table>
	 <a href="#" class="btn btn-primary" id="addVariety">+Add More</a>
	 <div class="clearfix"></div>
       <div class="margin-top-50">
<div class="col-md-3 col-sm-3 col-xs-6">
<div class="col-md-12 col-xs-12">
 <div class="form-group">
 <label><strong>Name of the Grader</strong></label><input type="text" id="name_grader" class="form-control" readonly value="${fullname}">
 </div>
 </div>
</div>
<div class="col-md-3 col-sm-3 col-xs-6">
<div class="col-md-12 col-xs-12">
 <div class="form-group">
 <label><strong>Verified By</strong></label><input type="text" class="form-control" readonly>
 </div>
 </div>
</div>
<div class="col-md-3 col-sm-3 col-xs-6">
<div class="col-md-12 col-xs-12">
 <div class="form-group">
 <label><strong>Supervisor Name</strong></label><input type="text" id="supervisorName" class="form-control">
 </div>
 </div>
</div>
<div class="col-md-3 col-sm-3 col-xs-6">
<div class="col-md-12 col-xs-12">
 <div class="form-group">
 <label><strong>Phone No</strong></label><input type="text" class="form-control" id="phone_number">
 </div>
 </div>
</div>
                <div class="form-group">
                  <input type="button" id="create_weigh_button" class=" btn-primary btn-lg no-radius center-block btn-sub my-btn" value="Submit">
                </div>
                </div>
               </form>
                </div>
              </div>
            </div>
          </div>
          <script type="text/javascript">

 var ncnt=1;
 var ncnt1=1;
 var countValue=0;
 var countValueWeight=0;
 var countValueNet=0;
 $(document).ready(function(){
		$(".addCF").click(function(){
			if($( '#netWeight').val()=='' || $( '#netWeight').val()==undefined || $( '#netWeight').val()==null
					|| $( '#netWeight').val()=='selectone')
					{		alert("Please select single net weight to proceed for the weighment");
							return false;
					}
					ncnt=parseInt($('#customFields tbody:last tr:last input[type=text]').val()) || 0;
		ncnt++;
			$("#customFields").append('<tr valign="top"><td><input type="text" class="form-control" id="slno'+ncnt+'" name="slno[]" value="'+ncnt+'"></td><td><input type="text" onblur="calculateSum()" class="form-control" id="count'+ncnt+'" name="count[]"></td><td><input type="text" class="form-control" id="weight'+ncnt+'" name="weight[]" onblur="calculateSum()"></td><td><input type="text" class="form-control" id="nets'+ncnt+'" name="nets[]" onblur="calculateSum()"></td><td class="no-border"><a href="javascript:void(0);" class="remCF btn btn-danger"><i class="fa fa-remove"></i></a></td></tr>');	});
	    $("#customFields").on('click','.remCF',function(){
	        $(this).parent().parent().remove();
			calculateSum();
			$("#customFields tbody tr").each(function(index) {
				  $cells = $(this).find("td");
				   $cells.each(function(cellIndex,ele) {
					$(ele).find('input[id^="slno"]').val(index+1);
				   $(ele).attr('id',"slno"+(index+1));
				
				  });    
				});
							ncnt--;
	    });
});
 function calculateSum()
	{
		
				$("#customFields tbody tr").each(function(index) {
					$cells = $(this).find("td");
					$cells.each(function(cellIndex,ele) {
						if(cellIndex==1)
						{
							if(!isNaN(($(ele).find('input[id^="count"]').val())))
							{
									var countLocal = parseInt($(ele).find('input[id^="count"]').val()) || 0;
								countValue=countValue+countLocal;
									//alert(countValue);
								$("#totalCount").val(countValue);
							}
							else{
								alert("Please enter numeric only");
							}
						}
						if(cellIndex==2)
						{
							if(!isNaN(($(ele).find('input[id^="weight"]').val())))
							{
								var sd=$(ele).find('input[id^="weight"]').val();
								var countLocalWight = parseFloat(sd) || 0.000;
								countValueWeight=countValueWeight+countLocalWight;
								 $("#totalWeight").val(countValueWeight.toFixed(3));
							}
							else{
								alert("Please enter numeric only");
							}
						}
					  
					 if(cellIndex==3)
						{
							if(!isNaN(($(ele).find('input[id^="nets"]').val())))
							{
							var countLocalNet = parseInt($(ele).find('input[id^="nets"]').val()) || 0;
								countValueNet=countValueNet+countLocalNet;
								 $("#totalNets").val(countValueNet);
							}
							else{
								alert("Please enter numeric only");
							}
						}
			
				  });  
				 
				});
				countValue=0;
				countValueWeight=0;
				countValueNet=0;
	}
 $(document).ready(function(){
		$("#create_weigh_button").click(function(){
				if($("#formwieghment").valid() && CalMaterialTubs())
			{
			var model = {}
	        model ["billChequeName"] = $("#chequeue_text").val();
			model ["billDate"]=new Date($("#weighment_date").val());
			model ["billCreDt"]=new Date($("#weighment_date").val());
		    model ["billFormerName"]=$("#weighment_farmer").val();
			model ["billAgentName"]=$("#weighment_agent").val();
			model ["billPlace"]=$("#weighment_place").val();
			model ["billPlantId"]=$('#plantsId').val();
			model ["billTruckNUmber"]=$('#truck_no').val();
			model ["billDriverName"]=$('#driver_name').val();
			model ["billDispatchTime"]=new Date($('#dispatch_time').val());
			model ["billArrivalTime"]=new Date($('#arrival_time').val());
			model ["billIceQty"]=$('#ice_qty').val();
			model ["billSignGrader"]=$('#name_grader').val();
			model ["billGraderPh"]=$('#phone_number').val();
			model ["billVim"]=$('#billVim').val();
			model ["billBt"]=$('#billBt').val();
			model ["billDispatchedBvrm"]=$('#billDispatchedBvrm').val();
			model ["billDispatchedNsp"]=$('#billDispatchedNsp').val();
			model ["billFormerMobile"]=$('#weighment_farmer_mob').val();
			model ["billAgentMobile"]=$('#weighment_agent_phno').val();
			model ["billLotNo"]=$('#weighment_lotNo').val();
			model ["verifiedBy"]=$('#verifiedBy').val();
			model ["billTotalTubs"]=$('#total_tubs').val();
			model ["billEmpty"]=$('#empty_tubs').val();
			model ["billMaterialTubs"]=$('#material_tub').val();
			model ["billSingleNetWeight"]=$('#netWeight').val();
			model ["billSupervisorName"]=$("#supervisorName").val();
			model ["billTotalNetWeight"]=$("#totalWeight").val();
			model ["billTotalNets"]=$("#totalNets").val();
			//model ["billPlantId"]=$('#phone_number').val();
				var purchageBillDetails = [];
				var $headers = $("#customFields thead th");
				var $rows = $("#customFields tbody tr").each(function(index) {
				  $cells = $(this).find("td");
				  purchageBillDetails[index] = {};
				  $cells.each(function(cellIndex) {
				    purchageBillDetails[index][$($headers[cellIndex]).attr("id")] = $(this).find("input").val();
				  });    
				});
				var weighmentVarietyDetails = [];
				var rows=$("#addVarietyTab").find('tbody tr').each(function(indexrow,objtablerow)
					{
						 weighmentVarietyDetails[indexrow] = {};

						$(objtablerow).find("td").each(function(cellIndex,element) {
							//alert($(element).find('select').is("select"));
							//alert($(element).find("option:selected").val());
							//alert($(element).html().type);
							if(!$(element).find('select').is("select"))
							{
							weighmentVarietyDetails[indexrow][$(element).attr('class')] =$(element).find("input").val();
							
							}
							else{

								weighmentVarietyDetails[indexrow][$(element).attr('class')]=$(element).find("option:selected").val();
							}
							
						});
					
					
					});
				model.purchageBillDetails = purchageBillDetails;
				model.weighmentVarietyDetails=weighmentVarietyDetails;

				var token = $('#csrfToken').val();
		var header = $('#csrfHeader').val()
	$.ajax({
 type : 'POST',
 url : "/jme-app/createWeighment",
 data: JSON.stringify(model),
 dataType : 'json',
 beforeSend: function(xhr) {
     xhr.setRequestHeader("Accept", "application/json");
     xhr.setRequestHeader("Content-Type", "application/json");
     xhr.setRequestHeader(header, token);
 },
 success : function(result) {
 	$("#formwieghment")[0].reset();
 	 $("#customFields").find("tr:gt(1)").remove();
 	 ncnt=1;
		alert("Your Details have been updated successfully.Your LOT NO is :"+result.billLotNo);
		
 },
 error : function(jqXHR, textStatus, errorThrown) {
     var exceptionVO = jQuery.parseJSON(jqXHR.responseText);
     alert("errorOccured Form Submission is not happening"+jqXHR.status+exceptionVO.errMsg+exceptionVO.errCode+exceptionVO.errorMethod);
		    }
		});
			}
 });
	});
</script>
<script>
  $( function() {
    $( "#weighment_date" ).datepicker();
	//$("#dispatch_time").timepicker();
	
	
  } );
  
  $("#billVim").on('change', function() {
	  if ($(this).is(':checked')) {
	    $(this).attr('value', 'true');
	  } else {
	    $(this).attr('value', 'false');
	  }
	  
		$('#checkbox-value').text($('#billVim').val());
  });
  
  $("#billBt").on('change', function() {
	  if ($(this).is(':checked')) {
	    $(this).attr('value', 'true');
	  } else {
	    $(this).attr('value', 'false');
	  }
	  
		$('#checkbox-value').text($('#billBt').val());
  });
  
  
  $("#billDispatchedBvrm").on('change', function() {
	  if ($(this).is(':checked')) {
	    $(this).attr('value', 'true');
	  } else {
	    $(this).attr('value', 'false');
	  }
	  
		$('#checkbox-value').text($('#billDispatchedBvrm').val());
  });
  
  
  $("#billDispatchedNsp").on('change', function() {
	  if ($(this).is(':checked')) {
	    $(this).attr('value', 'true');
	  } else {
	    $(this).attr('value', 'false');
	  }
	  
		$('#checkbox-value').text($('#billDispatchedNsp').val());
  });
  
    </script>
      <script>
  $.datetimepicker.setLocale('en');

$('#datetimepicker_format').datetimepicker({value:'2015/04/15 05:03', format: $("#datetimepicker_format_value").val()});
console.log($('#datetimepicker_format').datetimepicker('getValue'));

$("#datetimepicker_format_change").on("click", function(e){
	$("#datetimepicker_format").data('xdsoft_datetimepicker').setOptions({format: $("#datetimepicker_format_value").val()});
});
$("#datetimepicker_format_locale").on("change", function(e){
	$.datetimepicker.setLocale($(e.currentTarget).val());
});

$('#datetimepicker').datetimepicker({
dayOfWeekStart : 1,
lang:'en',
disabledDates:['1986/01/08','1986/01/09','1986/01/10'],
startDate:	'1986/01/05'
});
$('#datetimepicker').datetimepicker({value:'2015/04/15 05:03',step:10});

$('.some_class').datetimepicker();

$('#default_datetimepicker').datetimepicker({
	formatTime:'H:i',
	formatDate:'d.m.Y',
	//defaultDate:'8.12.1986', // it's my birthday
	defaultDate:'+03.01.1970', // it's my birthday
	defaultTime:'10:00',
	timepickerScrollbar:false
});

$('#datetimepicker10').datetimepicker({
	step:5,
	inline:true
});
$('#datetimepicker_mask').datetimepicker({
	mask:'9999/19/39 29:59'
});

$('#datetimepicker1').datetimepicker({
	datepicker:false,
	format:'H:i',
	step:5
});
$('#datetimepicker2').datetimepicker({
	yearOffset:222,
	lang:'ch',
	timepicker:false,
	format:'d/m/Y',
	formatDate:'Y/m/d',
	minDate:'-1970/01/02', // yesterday is minimum date
	maxDate:'+1970/01/02' // and tommorow is maximum date calendar
});
$('#datetimepicker3').datetimepicker({
	inline:true
});
$('#datetimepicker4').datetimepicker();
$('#open').click(function(){
	$('#datetimepicker4').datetimepicker('show');
});
$('#close').click(function(){
	$('#datetimepicker4').datetimepicker('hide');
});
$('#reset').click(function(){
	$('#datetimepicker4').datetimepicker('reset');
});
$('#datetimepicker5').datetimepicker({
	datepicker:false,
	allowTimes:['12:00','13:00','15:00','17:00','17:05','17:20','19:00','20:00'],
	step:5
});
$('#datetimepicker6').datetimepicker();
$('#destroy').click(function(){
	if( $('#datetimepicker6').data('xdsoft_datetimepicker') ){
		$('#datetimepicker6').datetimepicker('destroy');
		this.value = 'create';
	}else{
		$('#datetimepicker6').datetimepicker();
		this.value = 'destroy';
	}
});
var logic = function( currentDateTime ){
	if (currentDateTime && currentDateTime.getDay() == 6){
		this.setOptions({
			minTime:'11:00'
		});
	}else
		this.setOptions({
			minTime:'8:00'
		});
};
$('#datetimepicker7').datetimepicker({
	onChangeDateTime:logic,
	onShow:logic
});
$('#datetimepicker8').datetimepicker({
	onGenerate:function( ct ){
		$(this).find('.xdsoft_date')
			.toggleClass('xdsoft_disabled');
	},
	minDate:'-1970/01/2',
	maxDate:'+1970/01/2',
	timepicker:false
});
$('#datetimepicker9').datetimepicker({
	onGenerate:function( ct ){
		$(this).find('.xdsoft_date.xdsoft_weekend')
			.addClass('xdsoft_disabled');
	},
	weekends:['01.01.2014','02.01.2014','03.01.2014','04.01.2014','05.01.2014','06.01.2014'],
	timepicker:false
});
var dateToDisable = new Date();
	dateToDisable.setDate(dateToDisable.getDate() + 2);
$('#datetimepicker11').datetimepicker({
	beforeShowDay: function(date) {
		if (date.getMonth() == dateToDisable.getMonth() && date.getDate() == dateToDisable.getDate()) {
			return [false, ""]
		}

		return [true, ""];
	}
});
$('#datetimepicker12').datetimepicker({
	beforeShowDay: function(date) {
		if (date.getMonth() == dateToDisable.getMonth() && date.getDate() == dateToDisable.getDate()) {
			return [true, "custom-date-style"];
		}

		return [true, ""];
	}
});
$('#datetimepicker_dark').datetimepicker({theme:'dark'})

$(document).ready(function(){
// initialize the plugin on DOM ready
    $("#formwieghment").validate({ 
        // all rules and options,
        rules: {
            weighment_farmer: {
                required: true
                
            },
           weighment_agent :{
                required: true
            },
			
			 plantsId: {
                selectcheck: true
            },
			 count: {
                required: true,
				number: true
            },
			weight: {
                required: true,
				number: true
            },
			nets: {
                required: true,
				number: true
            },
			weighment_farmer_mob: {
                number: true
				 
            },
			weighment_agent_phno: {
               number: true
			    
            },
            totalWeight: {
				required:true,
				number: true
			},
			totalNets: {
					required:true,
					number: true
				},
				weighment_farmer_mob: {
					required:true,
					number: true
				},
				empty_tubs:{
				
					number: true
				},
				material_tub:{
					number: true
				},
				ice_qty:
				{
					number: true
				},
				chequeue_text:
				{
					required:true
				}
				
        }
    });
	
 jQuery.validator.addMethod('selectcheck', function (value) {
	// alert(value);
        return (value != '0');
    }, "Plant Name is required");
	 $('input[name^="count"]').rules({
               
                required: true
            });
});

function CalMaterialTubs(){
	var emptyTubs = parseInt($('#empty_tubs').val()) || 0;
	var ice_tubs = parseInt($('#ice_qty').val()) || 0;
	var totalTubs=ice_tubs+emptyTubs;
	var material_tub=$('#material_tub').val();
	var remainingTubs=totalTubs-material_tub;
	
	
	if(totalTubs<0)
	{
	alert("Please enter correct values in EmptyTubs/Ice Tubs");
	return false;
	}
	if(remainingTubs<0)
	{
		alert("Please enter correct values in Material Tubs/EmptyTubs/Ice Tubs");
		return false;
	}
	//if($('#empty_tubs').val()!='' && $('#ice_tubs').val()!='' && !(materialTubs<0))
	$('#total_tubs').val(totalTubs);
		$("#remaining_tubs").val(remainingTubs);
return true;
}

function calculateSum()
{
	if($('#netWeight').val()=='' || $( '#netWeight').val()==undefined || $( '#netWeight').val()==null
			|| $( '#netWeight').val()=='selectone')
			{		alert("Please select single net weight to proceed for the weighment");
					return false;
			}
			$("#customFields tbody tr").each(function(index) {
				$cells = $(this).find("td");
				$cells.each(function(cellIndex,ele) {
					if(cellIndex==1)
					{
						if(!isNaN(($(ele).find('input[id^="count"]').val())))
						{
								var countLocal = parseInt($(ele).find('input[id^="count"]').val()) || 0;
							countValue=countValue+countLocal;
								//alert(countValue);
							$("#totalCount").val(countValue);
						}
						else{
							alert("Please enter numeric only");
						}
					}
					if(cellIndex==2)
					{
						if(!isNaN(($(ele).find('input[id^="weight"]').val())))
						{
							var sd=$(ele).find('input[id^="weight"]').val();
							var countLocalWight = parseFloat(sd) || 0.000;
							countValueWeight=countValueWeight+countLocalWight;
							 $("#totalWeight").val(countValueWeight.toFixed(3));
						}
						else{
							alert("Please enter numeric only");
						}
					}
				  
				 if(cellIndex==3)
					{
						if(!isNaN(($(ele).find('input[id^="nets"]').val())))
						{
						var countLocalNet = parseInt($(ele).find('input[id^="nets"]').val()) || 0;
							countValueNet=countValueNet+countLocalNet;
							 $("#totalNets").val(countValueNet);
							 
						}
						else{
							alert("Please enter numeric only");
						}
					}
					
	/*if($( '#netWeight').val()=='' || $( '#netWeight').val()==undefined || $( '#netWeight').val()==null
	|| $( '#netWeight').val()=='selectone')
	{		alert("Please select single net weight to proceed for the weighment");
			return false;
	}*/
		 var singleNetWeight=parseFloat($("#netWeight").val()) || 0.0;
		 var totalNetsCount=parseInt($("#totalNets").val()) || 0;
		 var totalWeightVal=parseFloat($("#totalWeight").val())||0.000;
		$("#totalWeight").val((countValueWeight.toFixed(3)-(singleNetWeight*countValueNet).toFixed(3)).toFixed(3));
		
			  });  
			 
			});
			countValue=0;
			countValueWeight=0;
			countValueNet=0;
}//end

$( document ).ready(function() {
    $('a[href="#addRowsByFromTo"]').click(function(){
		
	if($( '#netWeight').val()=='' || $( '#netWeight').val()==undefined || $( '#netWeight').val()==null
		|| $( '#netWeight').val()=='selectone')
		{		alert("Please select single net weight to proceed for the weighment");
				return false;
		}
		if($("#fromRow").val()!='' && $("#toRow").val()!='')
		{
				var fromValue=parseInt($("#fromRow").val()) || 0;
				var toValue=parseInt($("#toRow").val()) || 0;
				var countValue=parseFloat($("#addRowCount").val()) || 0;
				if(fromValue>toValue)
				{
				  alert("From value should not exceed To value");
				  return false;
				}
				if(fromValue<=0 || toValue<=0 || countValue<=0)
				{
					alert("From/To/Count values should not less than or equal to Zero");
					return false;
					
				}
				if($("#addRowCount").val()=='' || $("#addRowCount").val()==null || $("#addRowCount").val()==undefined)
				{
				 alert("Please Enter count");
				  return false;
				}
				$("#customFields tbody tr").each(function(index) {
				  $cells = $(this).find("td");
				 // purchageBillDetails[index] = {};
				 var slNoValue;
				  $cells.each(function(cellIndex) {
				   if(cellIndex==0)
				   {
					   slNoValue=parseInt($(this).find("input").val())|| 0;
				   }
				   if(cellIndex==1)
				   {
					   if(slNoValue>=fromValue && slNoValue<=toValue)
					   {
						   $(this).find("input").val($("#addRowCount").val());

					   }
				   }
				  });    
				});
				/*var lastSlNo=parseInt($('#customFields tbody:last tr:last input[type=text]').val()) || 1;
				for(count =1; count <= toValue; count++)
				{
						lastSlNo++;
						
					$("#customFields").append('<tr valign="top"><td><input type="text" class="form-control" id="slno'+lastSlNo+'" name="slno[]" value="'+lastSlNo+'"></td><td><input type="text" onblur="calculateSum()" class="form-control" id="count'+lastSlNo+'" name="count[]" data-rule-required="true" data-rule-number="true" value="'+$("#addRowCount").val()+'"></td><td><input type="text" class="form-control" id="weight'+lastSlNo+'" name="weight[]" onblur="calculateSum()" data-rule-required="true" data-rule-number="true"></td><td><input type="text" class="form-control" id="nets'+lastSlNo+'" name="nets[]" onblur="calculateSum()" data-rule-required="true" data-rule-number="true"></td><td class="no-border"><a href="javascript:void(0);" class="remCF btn btn-danger"><i class="fa fa-remove"></i></a></td></tr>');
				}*/
				
				$("#addRowCount").val('');
				$("#toRow").val('');
				$("#fromRow").val('');
		}
		else{
		alert("Please Enter From and To values to add rows");
		return false;
		}
		 });
});//end

$(document).ready(function(){
	$("#addVariety").click(function(){
		
	var ncnt1=parseInt($('#addVarietyTab tbody:last tr:last input[type=text]').val()) || 0;
	ncnt1++;

	$("#addVarietyTab").append('<tr valign="top"><td><input type="text" class="form-control" id="slnoV'+ncnt1+'" name="slnoV[]" value="'+ncnt1+'" readonly placeholder="SL No"></td><td class="billedVarietyName"><select id="VarietyV'+ncnt1+'" class="form-control">  <option value="Select Variety">--Select Variety--</option><option value="Peeling">Peeling</option><option value="Discoloured">Discoloured</option><option value="Black Spot">Black Spot</option> <option value="Normal">Normal</option></select></td><td class="billedBillVarietyCount"><input type="text"  class="form-control" id="countV'+ncnt1+'" name="countV[]" placeholder="Count"></td><td class="billedVarietyWgtKgs"><input type="text" class="form-control" id="weightV'+ncnt1+'" name="weightV[]" placeholder="Weight"></td><td class="no-border"><a href="javascript:void(0);" class="remCF1 btn btn-danger"><i class="fa fa-remove"></i></a></td></tr>');	
	return false;			
		});
    $("#addVarietyTab").on('click','.remCF1',function(){
        $(this).parent().parent().remove();
		//calculateSum();
		$("#addVarietyTab tbody tr").each(function(index) {
			  $cells = $(this).find("td");
			   $cells.each(function(cellIndex,ele) {
				$(ele).find('input[id^="slno"]').val(index+1);
			   $(ele).attr('id',"slnoV"+(index+1));
			
			  });    
			});
						ncnt1--;
    });
});
</script>