<html>
<body>
<link rel="stylesheet" href="static/css/style.css" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="static/css/checkbox.css" type="text/css">

<div role="tabpanel" class="tab-pane" id="profile">
            
            <form class="fotm-horizontal">
            <div class="tb-header pd15">
               <div class="col-md-2 col-sm-3 col-xs-3">
               <div class="jme-logo">
               <img src="static/img/logo.png">
               </div>
               </div>
               <div class="col-md-8 col-sm-6 col-xs-9">
               
               <h1 class="text-center"><strong>JAGADEESH MARINE EXPORTS</strong></h1>
               <h3 class="text-center">NARSAPURAM</h3>
             
               </div>
               <div class="col-md-2 col-sm-3">
               <strong>SI.NO</strong>
            
               
               
               </div>
               <br>
               </div>
               <div class="clearfix"></div>
<div class="table-responsive invoice-resp margin-top-50">
  <table class="table table-bordered invoice_tbl">
    
    
    <tbody>
      <tr>
        <th colspan="3" align="center"><h3 class="text-center">Raw Material Purchase Report Cum Received Note</h3></th>
      </tr>
      
      <tr>
        <td colspan="2">
         <label class="col-md-2 col-sm-2"><strong>Bill Name : </strong></label>
         <div class="col-md-10 col-sm-10">
           <input type="text" class="form-control" value="${weighmentPurchase.billChequeName}">
         </div>
        </td>
        
         <td>
         <label class="col-md-3 col-sm-3"><strong>Date : </strong></label>
         <div class="col-md-9 col-sm-9">
           <input type="date" class="form-control" value="${weighmentPurchase.billDate}">
         </div>
        </td>
      </tr>
      
      <tr>
         <td>
         <label class="col-md-4 col-sm-4"><strong>Farmer Name : </strong></label>
         <div class="col-md-8 col-sm-8">
           <input type="text" class="form-control" value="${weighmentPurchase.billFormerName}">
         </div>
        </td>
         <td>
         <label class="col-md-3 col-sm-3"><strong>Cell No : </strong></label>
         <div class="col-md-9 col-sm-9">
           <input type="tel" class="form-control" value="${weighmentPurchase.billFormerMobile}">
         </div>
        </td>
         <td>
         <label class="col-md-3 col-sm-3"><strong>Village : </strong></label>
         <div class="col-md-9 col-sm-9">
           <input type="text" class="form-control" value="${weighmentPurchase.billPlace}">
         </div>
        </td>
        
      </tr>
      
      <tr>
         <td class="no-border-btm">
         <label class="col-md-4 col-sm-4"><strong>Agent Name : </strong></label>
         <div class="col-md-8 col-sm-8">
           <input type="text" class="form-control" value="${weighmentPurchase.billAgentName}">
         </div>
        </td>
         <td class="">
         <label class="col-md-3 col-sm-3"><strong>Cell No : </strong></label>
         <div class="col-md-9 col-sm-9">
           <input type="tel" class="form-control" value="${weighmentPurchase.billAgentMobile}">
         </div>
        </td>
         <td class="no-border-btm">
         <label class="col-md-3 col-sm-3"><strong>Lot No : </strong></label>
         <div class="col-md-9 col-sm-9">
           <input type="text" class="form-control" id="pur_lot_no" value="${weighmentPurchase.billLotNo}">
         </div>
        </td>
        
      </tr>
      
      <tr>
      <td colspan="3" class="no-padding no-border">
      <div class="row">
      <div class="col-md-6 col-sm-6 ">
      <table class="table table-bordered invoice_tbl">
           <tr>
             <th colspan="3" align="center" class="text-center">Company Count / Quality .<span class="pd_lft">Verity</span></th>
           </tr>
           
             <tr>
        <th>Details</th>
        <th>Total Pies 25 KG</th>
        <th>1 Kg C</th>
      </tr>
      
           <tr>
         
        <th width="30%">25 Kg Count</th>
        <th><input type="text" class="form-control" id="25_kg_count" name="25_kg_count"></th>
       <th><input type="text" class="form-control" id="" name=""></th>
      </tr>
      
       <tr>
        <th>Peeling</th>
        <th><input type="text" class="form-control" id="peeling_count" name=""></th>
       <th><input type="text" class="form-control" id="" name=""></th>
      </tr>
      
       <tr>
        <th>Discoloured</th>
        <th><input type="text" class="form-control" id="discoloured_count" name=""></th>
       <th><input type="text" class="form-control" id="" name=""></th>
      </tr>
      
       <tr>
        <th>Black Spot</th>
        <th><input type="text" class="form-control" id="blackspot_count" name=""></th>
       <th><input type="text" class="form-control" id="" name=""></th>
      </tr>
     
         </table>
         
         
       </div>  
       <div class="col-md-6 col-sm-6">
         <table class="table table-bordered invoice_tbl">
           <tr>
             <th colspan="3"  class="text-center">Company Count / Quality.<span class="pd_lft">Verity</span></th>
           </tr>
            <tr>
        <th>Total Pies 25 Kg</th>
        <th>1 Kg C</th>
        <th>Avarage</th>
      </tr>

           <tr>
           
        <th><input type="text" class="form-control" id="" name=""></th>
        <th><input type="text" class="form-control" id="" name=""></th>
       <th><input type="text" class="form-control" id="" name=""></th>
      </tr>
      
       <tr>
        <th><input type="text" class="form-control" id="" name=""></th>
        <th><input type="text" class="form-control" id="" name=""></th>
       <th><input type="text" class="form-control" id="" name=""></th>
      </tr>
      
       <tr>
        <th><input type="text" class="form-control" id="" name=""></th>
        <th><input type="text" class="form-control" id="" name=""></th>
       <th><input type="text" class="form-control" id="" name=""></th>
      </tr>
      
       <tr>
        <th><input type="text" class="form-control" id="" name=""></th>
        <th><input type="text" class="form-control" id="" name=""></th>
       <th><input type="text" class="form-control" id="" name=""></th>
      </tr>
         </table>
         
         </div>
         </div>
         </td>
       </tr>
       
       
       
       <tr>
      <td colspan="3" class="no-padding no-border">
      <div class="row">
      <div class="col-md-6 col-sm-6 ">
      
         
         <table class="table table-bordered invoice_tbl" id="tub_dtl">
      
      
    
	  <thead>
      <tr>
        <th>Material Tubs</th>
        <th>Empty </th>
        <th>Total Tubs </th>
		 <th colspan="4" class="text-center">Quantity Details</th>
   
     
       <th colspan="3" align="center">Tubs Details</th>
       <th rowspan="2" valign="middle" >Quantity</th>
      </tr>
	  </thead>
	  <tbody>
      <tr>
        <td><input type="text" class="form-control" id="billMaterialTubs" name="tub_material_tub-0"></td>
        <td><input type="text" class="form-control" id="billEmpty" name="tub_empty-0"></td>
        <td><input type="text" class="form-control" id="billTotalTubs" name="tub_total_tub-0"></td>
        <td><input type="text" class="form-control" id="billQuantity" name="tub_qty-0"></td>
      </tr>
      
       <tr>
        <td><input type="text" class="form-control" id="billMaterialTubs" name="tub_material_tub-1"></td>
        <td><input type="text" class="form-control" id="billEmpty" name="tub_empty-1"></td>
        <td><input type="text" class="form-control" id="billTotalTubs" name="tub_total_tub-1"></td>
        <td><input type="text" class="form-control" id="billQuantity" name="tub_qty-1"></td>
      </tr>
      
     
	  </tbody>
	  
      <!--  <th colspan="2">Driver Sign</th>
          <th colspan="2">Grader Sign</th>-->
         </table>
       </div>  
       <div class="col-md-6 col-sm-6">
         
         <table class="table table-bordered trnsport_tbl invoice_tbl">
          
      <tr>
        <th colspan="3" class="text-center">Transport Details</th>
      </tr>
      <tr>
        <td colspan="3">
        <label class="col-md-3 col-sm-3">Truck No :</label>
        <div class="col-md-9 col-sm-9">
          <input type="text" class="form-control" id="" name="">
        </div>
        </td>
      </tr>
      
      <tr>
        <td colspan="3">
        <label class="col-md-3 col-sm-3">Driver :</label>
        <div class="col-md-9 col-sm-9">
          <input type="text" class="form-control" id="pur_driver" name="">
        </div>
        </td>
      </tr>
      
      <tr>
        <td colspan="3">
        <label class="col-md-3 col-sm-3"> Dispatched :</label>
        <div class="col-md-9 col-sm-9">
        <div class="row">
          <div class="col-md-6 col-sm-6">
             BVRM <input type="checkbox" name="" id="">   
          </div>
          
          <div class="col-md-6 col-sm-6">
             NSP <input type="checkbox" name="" id="">
          </div>
        </div>
          
        </div>
        </td>
      </tr>
      
      <tr>
        <td colspan="3">
        <label class="col-md-3 col-sm-3">Dipatch Time :</label>
        <div class="col-md-9 col-sm-9">
          <input type="time" class="form-control" id="" name="">
        </div>
        </td>
      </tr>
      
      <tr>
        <td colspan="3">
        <label class="col-md-3 col-sm-3">Arrival Time  :</label>
        <div class="col-md-9 col-sm-9">
          <input type="time" class="form-control" id="" name="">
        </div>
        </td>
      </tr>
      
      <tr><th>Supervisor Sign</th>
          <th>Agent / Farmer Sign</th></tr>
         </table>
         </div>
         </div>
         </td>
       </tr>
	        
    </tbody>
  
  
  </table>
  <div id="quantitylist">
   <!--<tr>
                  <th class="text-center" colspan="1">For Office Use Only</th>
                  <th class="text-center" colspan="2">Bill No</th>
                  <th class="text-center"><input type="checkbox"> Certificate</th>
                  <th class="text-center"><input type="checkbox">  No Certificates</th>
                </tr>-->
                
            <table class="table table-bordered invoice_tbl" id="table0">
               <thead>
                <tr>
                  <th>veriety/Count Quality</th>
                  <th>Quantity</th>
                  <th>Rate</th>
                  <th colspan="2" rowspan="7" width="50%">Remarks<textarea class="form-control" rows="13"></textarea></th>
                </tr>
                </thead>
				<tbody>
                <tr>
                  <td><input type="text" class="form-control" name="qty_veriety_type" id="varietyType"></td>
                   <td><input type="text" class="form-control" name="qty_defualt_qty" id="billQuantity"></td>
                    <td><input type="text" class="form-control" name="qty_defualt_rate" id="billPurchageRate" value=""></td>
                </tr>
                
                 <tr>
                  <td><strong>Peeling</strong></td>
                   <td><input type="text" class="form-control" name="qty_peeling" id="billQuantity"></td>
                    <td><input type="text" class="form-control" name="qty_rate_peeling" id="billPurchageRate"></td>
                </tr>
                 <tr>
                  <td><strong>Discoloured</strong></td>
                   <td><input type="text" class="form-control" name="qty_discoloured" id="billQuantity"></td>
                    <td><input type="text" class="form-control" name="rate_discoloured" id="billPurchageRate"></td>
                </tr>
                
                 <tr>
                  <td><strong>Black Spot</strong></td>
                   <td><input type="text" class="form-control" name="qty_blackspot" id="billQuantity"></td>
                    <td><input type="text" class="form-control" name="qty_rate_blackspot" id="billPurchageRate"></td>
                </tr>
                
                </tbody>
                
            </table>
			<table class="table table-bordered invoice_tbl-1" id="table1">
                  <thead>             
                <tr>
                  <th>veriety/Count Quality</th>
                  <th>Quantity</th>
                  <th>Rate</th>
                  <th colspan="2" rowspan="7" width="50%">Remarks<textarea class="form-control" rows="13"></textarea></th>
                </tr>
                 </thead> 
				 <tbody>
                 <tr>
                  <td><input type="text" class="form-control" name="qty_veriety_type" id="varietyType"></td>
                   <td><input type="text" class="form-control" name="qty_defualt_qty" id="billQuantity"></td>
                    <td><input type="text" class="form-control" name="qty_defualt_rate" id="billPurchageRate"></td>
                </tr>
                
                 <tr>
                  <td><strong>Peeling</strong></td>
                   <td><input type="text" class="form-control" name="qty_peeling" id="billQuantity"></td>
                    <td><input type="text" class="form-control" name="qty_rate_peeling" id="billPurchageRate"></td>
                </tr>
                 <tr>
                  <td><strong>Discoloured</strong></td>
                   <td><input type="text" class="form-control" name="qty_discoloured" id="billQuantity"></td>
                    <td><input type="text" class="form-control" name="qty_rate_discoloured" id="billPurchageRate"></td>
                </tr>
                
                 <tr>
                  <td><strong>Black Spot</strong></td>
                   <td><input type="text" class="form-control" name="qty_blackspot" id="billQuantity"></td>
                    <td><input type="text" class="form-control" name="qty_rate_blackspot" id="billPurchageRate"></td>
                </tr>
               
                
				</tbody>
				                
            </table>
			<tr>
                  <td class="text-center"><strong>Total :</strong></td>
                </tr> 

</div>
 
                    <input type="button" id="invoicesubmit" class="btn btn-success btn-lg no-radius center-block btn-sub" value="Submit">
					      <input type="hidden" id="csrfToken" value="${_csrf.token}"/>
<input type="hidden" id="csrfHeader" value="${_csrf.headerName}"/>
         

  </div>
</form>
            
            </div><!-- invoice-->
			 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

   <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
			<script>
			$(document).ready(function(){
	$("#invoicesubmit").click(function(){
				var model = {}
	       // model ["billReportLotNo"] = $("#pur_lot_no").val();
			model ["billDriverName"]=$("#pur_driver").val();
		    model ["billPurchageManager"]=$("#pur_manager").val();
			model ["billPurchageAuthorized"]=$("#pur_authorized").val();
			model ["billPlantManager"]=$("#plant_mgr").val();
			model ["billAccountManager"]=$("#acct_mgr").val();
			model ["billAuthorized"]=$("#auth_mgr").val();	
			model ["billCertificate"]=$("#auth_mgr").val();	
			var purchageTubDetails = [];
			var billReportLotNo={};
			var $headers = $("#tub_dtl thead th");
							var $rows = $("#tub_dtl tbody tr").each(function(index,table) {
								//alert($(table).html());
				  $cells = $(this).find("td");
				  purchageTubDetails[index] = {};
				  $cells.each(function(cellIndex,element) {
					 // alert($(this).find("input").val());
					  //if($(this).find("input").val()!="" && $(this).find("input").val()!='undefined')
					 // {
						purchageTubDetails[index][$(element).find('input[name^="tub_"]').attr('id')] = $(this).find("input").val();
					  //}
					  //else{
						//  alert("else block"+$(element).html());
					 // }
				  });    
				});

console.log(purchageTubDetails); //
			//	console.log($.parseJSON(purchageTubDetails));
				var comp_count={};
				comp_count["bill25kGCount"]=$("#25_kg_count").val();
				comp_count["billPeeling"]=$("#peeling_count").val();
				comp_count["billDiscolored"]=$("#discoloured_count").val();
				comp_count["billBlackSpot"]=$("#blackspot_count").val();
				var purchageQuantityDetails = [];
				//var i=0
				$('#quantitylist table').each(function(){ 
				//alert(this.id);  
			var $rows = $("#quantitylist table tbody tr").each(function(index,table) {
				//alert(index);
				//alert($(table).html());
				$cells = $(table).find("td");
					 purchageQuantityDetails[index] = {};

					$cells.each(function(cellIndex,element) {
						//alert($(element).find('input[name^="qty_"]').attr('id'));
						//alert($(this).find("input").val());
						var str=$(this).find("input").val();
						//alert(str);
						purchageQuantityDetails[index][$(element).find('input[name^="qty_"]').attr('id')] =str ;
					//console.log(purchageQuantityDetails);
					});
				/*$(table 'tbody tr').each(function(element){ 
					alert($(element).html());
					$cells = $(this).find("td");
					 purchageQuantityDetails[index] = {};
					$cells.each(function(cellIndex,element) {
						//alert($(element).find('input[name^="qty_"]').attr('id'));
						purchageQuantityDetails[index][$(element).find('input[name^="qty_"]').attr('id')] = $(this).find("input").val();
					
					});
					});*/
				});
				});
				console.log(purchageQuantityDetails);
				billReportLotNo["billLotNo"]=$("#pur_lot_no").val();
				model.billReportLotNo=billReportLotNo;
				model.purchagePayAmount=purchageQuantityDetails;
				model.purchageBillTubs = purchageTubDetails;
				model.purchageCompCountDetail = comp_count;
								console.log(model);
				var token = $('#csrfToken').val();
				var header = $('#csrfHeader').val()
					$.ajax({
    type : 'POST',
    url : "/jme-app/createPurchageBillReport",
    data: JSON.stringify(model),
    dataType : 'json',
    beforeSend: function(xhr) {
        xhr.setRequestHeader("Accept", "application/json");
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.setRequestHeader(header, token);
    },
    success : function(result) {
    	//$("#formwieghment")[0].reset();
    	// $("#customFields").find("tr:gt(1)").remove();
    	// ncnt=1;
		alert(result);
		
    },
    error : function(jqXHR, textStatus, errorThrown) {
        var exceptionVO = jQuery.parseJSON(jqXHR.responseText);
        alert("errorOccured Form Submission is not happening"+jqXHR.status+exceptionVO.errMsg+exceptionVO.errCode+exceptionVO.errorMethod);
		    }
		});//ajax

		});
	});
			</script>
</body>
</html>