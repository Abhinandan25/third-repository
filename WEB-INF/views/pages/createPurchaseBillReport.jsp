<!doctype html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <style>
     .page-title .title_left{width:100%;}
	 .table-responsive.invoice-resp{overflow-x:hidden;}
	 .form-control{background:none; border-color:#666; margin-bottom:5px;}
	 .table .table{background:none;}
	 .table-bordered>tbody>tr>td, .table-bordered>tbody>tr>th, .table-bordered>tfoot>tr>td, .table-bordered>tfoot>tr>th, .table-bordered>thead>tr>td, .table-bordered>thead>tr>th{border:#8e8888 1px solid;}
	 .spl-bordered>tbody>tr>td, .spl-bordered>tbody>tr>th, .spl-bordered>tfoot>tr>td, .spl-bordered>tfoot>tr>th, .spl-bordered>thead>tr>td, .spl-bordered>thead>tr>th{border:#8e8888 1px solid;}
.spl-bordered{border-right:1px solid #8e8888 !important; border-bottom:1px solid #8e8888 !important;}
.spl-bordered-left{border-left:1px solid #8e8888 !important;border-right:none !important; }
.table-bordered{border:none;}
label,th,td {color:#333}
.border-top-none{border-top:none !important;}

@media screen and (min-width:320px) and (max-width:767px){
 .table-responsive.invoice-resp{overflow-x:auto;}
}
.graderName_tubDetails{
	border: 1px solid #8e8888;
    border-top: none;
    margin: 0px;
    width: 100%;
    position: relative;
    top: -20px;
}
.graderName_tubDetails td {
    border-right: 1px solid #8e8888 !important;
    padding: 8px;
	
}
    </style>

<div class="">
<c:set var ="fullname" value ="${user.firstName} ${user.lastName}"/> 
            <div class="page-title">
              <div class="title_left">
              <div class="col-md-12">
              </div>
                <h3>Purchase Report </h3>
              </div>
              
            </div>
            
            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel" style="background:#fee801;">
                  <form class="fotm-horizontal" name="purchaseForm" id="purchaseForm">
            <div class="tb-header pd15">
               <div class="col-md-2 col-sm-3 col-xs-3 hidden-xs">
               <div class="jme-logo">
               <img src="static/img/logo.png">
               </div>
               </div>
               <div class="col-md-8 col-sm-6 col-xs-12">
               
               <h1 class="text-center heading-black">JAGADEESH MARINE EXPORTS</h1>
              
               <select class="form-control margin-top-50" id="plantsIdPurchase" name="plantsIdPurchase">
                 <option value="0">Select Plant</option>
                   <c:forEach var="plant" items="${plantListPurchase}">
                  <option value="${plant.billPlantId}">${plant.billPlantName}</option>
                 
                    </c:forEach>
               </select>
             
               </div>
               <div class="col-md-2 col-sm-3 hidden-xs">
               <strong class="text-black">SI.NO #  ${weighmentPurchase.billLotNo}</strong>
            
               
               
               </div>
               <br>
               </div>
               <br>
<br>
<div class="hidden-xs"><br>
<br>
<br>

</div>
<div class="clearfix"></div>
<div class="table-responsive invoice-resp margin-top-50">
  <table class="table table-bordered invoice_tbl no-border" style="border-bottom:none;">
    <tbody>
      <tr>
        <th colspan="3" align="center"><h3 class="text-center">Raw Material Purchase Report Cum Received Note</h3></th>
      </tr>
      
      <tr>
        <td colspan="2">
         <label class="col-md-2 col-sm-2"><strong>Bill Name :</strong></label>
         <div class="col-md-10 col-sm-10">
           <input type="text" id="chequeName" class="form-control" value="${weighmentPurchase.billChequeName}">
         </div>
        </td>
        
         <td>
         <label class="col-md-3 col-sm-3"><strong>Date :</strong></label>
         <div class="col-md-9 col-sm-9">
           <input type="text" id="billDate" class="form-control" id="datepicker" value="${weighmentPurchase.billDate}">
         </div>
        </td>
      </tr>
      
      <tr>
         <td>
         <label class="col-md-4 col-sm-4"><strong>Farmer Name :</strong></label>
         <div class="col-md-8 col-sm-8">
           <input type="text" id="farmerName" class="form-control" value="${weighmentPurchase.billFormerName}">
         </div>
        </td>
         <td>
         <label class="col-md-3 col-sm-3"><strong>Cell No :</strong></label>
         <div class="col-md-9 col-sm-9">
           <input type="tel" id="formerMobile" class="form-control" value="${weighmentPurchase.billFormerMobile}">
         </div>
        </td>
         <td>
         <label class="col-md-3 col-sm-3"><strong>Village : </strong></label>
         <div class="col-md-9 col-sm-9">
           <input type="text" id="place" class="form-control" value="${weighmentPurchase.billPlace}">
         </div>
        </td>
        
      </tr>
      
      <tr>
         <td class="no-border-btm">
         <label class="col-md-4 col-sm-4"><strong>Agent Name :</strong></label>
         <div class="col-md-8 col-sm-8">
           <input type="text" id="agentName"  class="form-control" value="${weighmentPurchase.billAgentName}">
         </div>
        </td>
         <td class="">
         <label class="col-md-3 col-sm-3"><strong>Cell No :</strong></label>
         <div class="col-md-9 col-sm-9">
           <input type="tel" id="agentMobile" class="form-control" value="${weighmentPurchase.billAgentMobile}">
         </div>
        </td>
         <td class="no-border-btm">
         <label class="col-md-3 col-sm-3"><strong>Lot No :</strong></label>
         <div class="col-md-9 col-sm-9">
           <input type="text" class="form-control" id="pur_lot_no" value="${weighmentPurchase.billLotNo}">
         </div>
        </td>
        
      </tr>
      
      <tr>
      <td colspan="3" class="no-padding no-border" style="border:none;">
      <div class="row">
      <div class="col-md-6 col-sm-6 ">
      <table class="table spl-bordered invoice_tbl" id="compCountDtl">
           <tr>
             <th colspan="4" align="center" class="text-center" style="border-top:none;">Company Count / Quality .<span class="pd_lft">Verity</span></th>
           </tr>
          
             <tr>
        <th>Details</th>
        <th>Total Pies 25 KG</th>
        <th>1 Kg C</th>
        <th>Count</th>
      </tr>
     
      <c:forEach var="listVarComp" items="${weighmentPurchase.totalCountQuantity}" varStatus="loopComp"> 
           <tr>
           
        <th width="30%">25 Kg Count</th>
        <th><input type="text" class="form-control" id="25kg1kgc-${loopComp.index}" name="bill25kGCount-${loopComp.index}" onblur="cal1kgCount(this.value,this.id)"></th>
       <th><input type="text" class="form-control" style="background:none" id="totalPiecies-${loopComp.index}" name="totalPiecies-${loopComp.index}" disabled></th>
       <th><input type="text"  class="form-control" style="background:none" id="count251kg-${loopComp.index}" name="billdCompCount-${loopComp.index}" value="${listVarComp.key}" disabled></th>
      </tr>
       </c:forEach>
       <tr>
        <th>Peeling</th>
        <th><input type="text" class="form-control" id="" name=""></th>
       <th><input type="text" class="form-control" id="" name=""></th>
      </tr>
      
       <tr>
        <th>Discoloured</th>
        <th><input type="text" class="form-control" id="" name=""></th>
       <th><input type="text" class="form-control" id="" name=""></th>
      </tr>
      
       <tr>
        <th>Black Spot</th>
        <th><input type="text" class="form-control" id="" name=""></th>
       <th><input type="text" class="form-control" id="" name=""></th>
      </tr>
     
         </table>
         
         
       </div>  
       <div class="col-md-6 col-sm-6">
         <table class="table spl-bordered spl-bordered-left  invoice_tbl" style="border-right:none;">
           <tr>
             <th colspan="3"  class="text-center" style="border-top:none;">Farmer Count / Quality.<span class="pd_lft">Variety</span></th>
           </tr>
            <tr>
        <th>Total Pies 25 Kg</th>
        <th>1 Kg C</th>
        <th>Average</th>
      </tr>

<c:forEach var="listVar" items="${weighmentPurchase.totalCountQuantity}">
           <tr>
        <th><input type="text" class="form-control" id="" name=""  ></th>
        <th><input type="text" class="form-control" id="" name="" style="background:none" value="${listVar.key}" disabled></th>
       <th><input type="text" class="form-control" id="" name=""></th>
      </tr>
       </c:forEach>
         </table>
         
         </div>
         </div>
         </td>
       </tr>
       
      
    </tbody>
    </table>
    
    <table class="table">
      <tr>
      <td colspan="3" class="no-padding no-border" style="border:none; border-top:1px solid #8e8888;">
      <div class="row">
      <div class="col-md-6 col-sm-6 ">
         <table class="table spl-bordered  invoice_tbl" id="tub_dtl">
         <thead>
         <tr> 
       <th colspan="4" class="text-center" style="border-top:none;">Quantity Details</th>
      </tr>
         
          <tr>
       <th colspan="3" align="center">Tubs Details</th>
       <th rowspan="2" valign="middle">Quantity</th>
      </tr>
      
      <tr>
        <th>Material Tubs</th>
        <th>Empty </th>
        <th>Total Tubs </th>
      </tr>
         </thead>
            
            <tbody>
            
           <tr>
        <td><input type="text" class="form-control" id="billMaterialTubs" name="tub_material_tub-0" value="${weighmentPurchase.billMaterialTubs}"></td>
        <td><input type="text" class="form-control" id="billEmpty" name="tub_empty-0" value="${weighmentPurchase.billEmpty}"></td>
        <td><input type="text" class="form-control" id="billTotalTubs" name="tub_total_tub-0" value="${weighmentPurchase.billTotalTubs}"></td>
        <td><input type="text" class="form-control" id="billQuantity" name="tub_qty-0"></td>
      </tr>
      
      <!-- <tr>
        <td><input type="text" class="form-control" id="billMaterialTubs" name="tub_material_tub-1"></td>
        <td><input type="text" class="form-control" id="billEmpty" name="tub_empty-1"></td>
        <td><input type="text" class="form-control" id="billTotalTubs" name="tub_total_tub-1"></td>
        <td><input type="text" class="form-control" id="billQuantity" name="tub_qty-1"></td>
      </tr>-->
	  
       <!--<tr> <td colspan="2"><label>Driver Sign</label>
       <input type="text" class="form-control"></td>
          <td colspan="2"><label>Grader Sign</label> <input type="text" class="form-control"></td></tr>'-->
		  
		  
            </tbody>
               </table>
			   
			   <table class="graderName_tubDetails">
<tbody><tr> <td colspan="2"><label>Driver Name</label>
       <input type="text" class="form-control" id="pur_driver" value="${weighmentPurchase.billDriverName}"></td>
          <td colspan="2"><label>Grader Name</label> <input type="text" id="pur_grader" class="form-control" value="${weighmentPurchase.billSignGrader}"></td></tr>

</tbody></table>
			   
       </div>  
       
      <div class="col-md-6 col-sm-6">
         
         <table class="table spl-bordered spl-bordered-left trnsport_tbl invoice_tbl">
         <thead>
            <tr>
        <th colspan="3" class="text-center" style="border-top:none;">Transport Details</th>
      </tr>
         </thead>
         
         <tbody>
          <tr>
        <td colspan="3">
        <label class="col-md-3 col-sm-3">Truck No :</label>
        <div class="col-md-9 col-sm-9">
          <input type="text" class="form-control" id="truckNumber" name="" value="${weighmentPurchase.billTruckNUmber}">
        </div>
        </td>
      </tr>
      
      <tr>
        <td colspan="3">
        <label class="col-md-3 col-sm-3">Driver :</label>
        <div class="col-md-9 col-sm-9">
          <input type="text" class="form-control" id="" name="" value="${weighmentPurchase.billDriverName}">
        </div>
        </td>
      </tr>
      
      <tr style="height:70px;">
        <td colspan="3">
        <label class="col-md-3 col-sm-3"> Dispatched :</label>
        <div class="col-md-9 col-sm-9">
        <div class="row">
        
          <div class="col-md-6 col-sm-6">
            <div class="checkbox checkbox-success checkbox-inline">
                        <input type="checkbox" class="styled" id="billDispatchedBvrm" value="false" ${weighmentPurchase.billDispatchedBvrm==true ? 'checked': ''}>
                        <label for="inlineCheckbox2"> BVRM </label>
                    </div>  
          </div>
          
          <div class="col-md-6 col-sm-6">
             <div class="checkbox checkbox-success checkbox-inline">
                        <input type="checkbox" class="styled" id="billDispatchedNsp" value="false" ${weighmentPurchase.billDispatchedNsp==true ? 'checked': ''}>
                        <label for="inlineCheckbox3"> NSP </label>
                    </div>
          </div>
        </div>
          
        </div>
        </td>
      </tr>
      
      <tr>
        <td colspan="3">
        <label class="col-md-3 col-sm-3">Dipatch Time :</label>
        <div class="col-md-9 col-sm-9">
          <input type="text" class="form-control time" id="basicExample" name="" value="${weighmentPurchase.billDispatchTime}">
        </div>
        </td>
      </tr>
      
      <tr>
        <td colspan="3">
        <label class="col-md-3 col-sm-3">Arrival Time :</label>
        <div class="col-md-9 col-sm-9">
          <input type="text" class="form-control" id="basicExample1" name="" value="${weighmentPurchase.billArrivalTime}">
        </div>
        </td>
      </tr>
      
      <tr><th><label>Supervisor Name</label>
      <input type="text" class="form-control" id="supervisorName" value="${weighmentPurchase.billSupervisorName}"></th>
          <th><label>Agent / Farmer Name</label><input type="text" id="formarName" class="form-control" value="${weighmentPurchase.billAgentName}"></th></tr>
         </tbody>
     
         </table>
         </div>
         </div>
         </td>
       </tr>
    </table>
    
     <table class="table table-bordered" style="border-right:1px solid #8e8888; border-bottom:none;">
         <thead>
           <tr>
             <tr>
                  <th class="text-center" colspan="3">For Office Use Only</th>
                  <th class="text-center" colspan="2">Bill No</th>
                  <th class="text-center"><div class="checkbox checkbox-success checkbox-inline">
                        <input type="checkbox" class="styled" id="billCertificate" value=false >
                        <label for="inlineCheckbox4"> Certificate </label>
                    </div></th>
                  <th class="text-center"><div class="checkbox checkbox-success checkbox-inline">
                        <input type="checkbox" class="styled" id="billNoCertificate" value="false" >
                        <label for="inlineCheckbox5"> No Certificates </label>
                    </div></th>
                </tr>
           </tr>
           
           <tr>
           <td colspan="8">
             <div class="row">
                 <div class="col-md-7 col-sm-7 col-xs-12" style="margin-top:-8px !important;" id="quantitylist">
                   <!-- <table class="table table-bordered">
                    <thead>
                      <tr>
                  <th>variety</th>
                   <th>Count Quality</th>
                  <th>Quantity</th>
                   <th>Pur.QT</th>
                  <th>Rate</th>
                  </tr>
                    </thead>
                    
                    <tbody>
                       <tr>
                  <td><input type="text" class="form-control" name="" id=""></td>
                   <td><input type="text" class="form-control" name="" id=""></td>
                    <td><input type="text" class="form-control" name="" id=""></td>
                     <td><input type="text" class="form-control" name="" id=""></td>
                    <td><input type="text" class="form-control" name="" id=""></td>
                </tr>
                
                 <tr>
                  <td><strong>Peeling</strong></td>
                   <td><input type="text" class="form-control" name="" id=""></td>
                    <td><input type="text" class="form-control" name="" id=""></td>
                     <td><input type="text" class="form-control" name="" id=""></td>
                    <td><input type="text" class="form-control" name="" id=""></td>
                </tr>
                 <tr>
                  <td><strong>Discoloured</strong></td>
                   <td><input type="text" class="form-control" name="" id=""></td>
                    <td><input type="text" class="form-control" name="" id=""></td>
                     <td><input type="text" class="form-control" name="" id=""></td>
                    <td><input type="text" class="form-control" name="" id=""></td>
                </tr>
                
                 <tr>
                  <td><strong>Black Spot</strong></td>
                   <td><input type="text" class="form-control" name="" id=""></td>
                    <td><input type="text" class="form-control" name="" id=""></td>
                     <td><input type="text" class="form-control" name="" id=""></td>
                    <td><input type="text" class="form-control" name="" id=""></td>
                </tr>
                
                 <tr>
                  <td><input type="text" class="form-control" name="" id=""></td>
                   <td><input type="text" class="form-control" name="" id=""></td>
                    <td><input type="text" class="form-control" name="" id=""></td>
                     <td><input type="text" class="form-control" name="" id=""></td>
                    <td><input type="text" class="form-control" name="" id=""></td>
                    
                </tr>
                    </tbody>
                   </table> -->
                    <c:forEach var="listVar" items="${weighmentPurchase.totalCountQuantity}" varStatus="loop">
                   <table class="table table-bordered" id="table-"${loop.index}>
                   <input type="hidden" name="quantityByCount-${loop.index}" id="quantityByCount-${loop.index}" value="${listVar.value}"/>
                   
                    <thead>
                      <tr style="border-top:1px solid #8e8888;">
                  <th>veriety</th>
                   <th>Count Quality</th>
                  <th>Quantity</th>
                   <th>Pur.QT</th>
                  <th>Rate</th>
                  </tr>
                    </thead>
                    
                    <tbody>
             		 <c:forEach var="varietyTypeObj" items="${varietyListPurchase}" varStatus="loopVariety">
			 		<c:set var="totalCountVarietyQuantityValue1"  value="${0.000}"/>
			 		<c:set var="totalCountVarietyQuantityShrimp"  value="${0}"/>
                  <tr>
					<td class="billVarietyId"><select class="form-control" id="billVarietyId-${loopVariety.index}">
                    <option value="">--Select--</option>
					<c:forEach var="varietyType" items="${varietyListPurchase}" varStatus="loopVtype">
						<c:set var="totalCountVarietyQuantityShrimp"  value="${totalCountVarietyQuantityShrimp}"/>
					<c:choose>
						<c:when test="${totalCountVarietyQuantityShrimp<1 && not empty weighmentPurchase.totalCountVarietyQuantity[listVar.key][varietyType.billShrimpType]}">
						 <c:set var="totalCountVarietyQuantityValue"  value="${weighmentPurchase.totalCountVarietyQuantity[listVar.key][varietyType.billShrimpType]}"/>
						<c:set var="totalCountVarietyQuantityValue1"  value="${totalCountVarietyQuantityValue}"/>
						<c:set var="totalCountVarietyQuantityShrimp"  value="${totalCountVarietyQuantityShrimp+1}"/>
				</c:when>
				<c:when test="${totalCountVarietyQuantityShrimp<1 && empty weighmentPurchase.totalCountVarietyQuantity[listVar.key][varietyType.billShrimpType]}">
				<c:set var="totalCountVarietyQuantityShrimp"  value="${totalCountVarietyQuantityShrimp}"/>
				</c:when>
				<c:otherwise>
				<c:set var="totalCountVarietyQuantityShrimp"  value="${totalCountVarietyQuantityShrimp+1}"/>
				</c:otherwise>
				</c:choose>
					<option value="${varietyType.billVarietyId}" ${totalCountVarietyQuantityShrimp==1 && not empty weighmentPurchase.totalCountVarietyQuantity[listVar.key][varietyType.billShrimpType] ? 'selected': ''}>${varietyType.billShrimpType}</option>
					<!--<option value="${varietyType.billVarietyId}">${varietyType.billShrimpType}</option>-->
 					<c:if test="${totalCountVarietyQuantityShrimp==1}">
					<c:set target="${weighmentPurchase.totalCountVarietyQuantity[listVar.key]}" property="${varietyType.billShrimpType}" value="${null}"/>
					</c:if>
					</c:forEach>
                  </select></td>
                   <td class="billCount"><input type="text" style="background:none;" value="${listVar.key}" class="form-control" name="billCount-${loop.index}${loopVariety.index}" id="billCount-${loop.index}${loopVariety.index}" disabled></td>
                    <td class="billQuantity"><input type="text" style="background:none;" value="${listVar.value}" class="form-control" name="billQuantity-${loop.index}${loopVariety.index}" id="billQuantity-${loop.index}${loopVariety.index}" disabled></td>
                     <td class="billPurchageQuantity"><input type="text" class="form-control" name="billPurchageQuantity-${loop.index}${loopVariety.index}" id="billPurchageQuantity-${loop.index}${loopVariety.index}" onblur="claculatePurchaseAmount()" value="${totalCountVarietyQuantityValue1}"></td>
                    <td class="billPurchageRate"><input type="text" class="form-control" name="billPurchageRate-${loop.index}${loopVariety.index}" id="billPurchageRate-${loop.index}${loopVariety.index}" onblur="claculatePurchaseAmount()"></td>
                </tr>
                 </c:forEach>
                
               
               
                    </tbody>
                   </table>
				   </c:forEach>
				   <table class="graderName_tubDetails" id="graderNameTable">
				   <tbody>
				    <tr>
                  <td class="text-center" colspan="3"><strong>Total Pur.Qty/Amt:</strong></td>
                   <td><input type="text" class="form-control" style="background:none;" name="billPurchaseQtyTotal" id="billPurchaseQtyTotal"  readonly></td>
                    <td><input type="text" class="form-control" style="background:none;" name="billPurchaseInVoiceAmtTotal" id="billPurchaseInVoiceAmtTotal"  readonly></</td>
                </tr> 
                </tbody>
				   </table>

                 </div>
                 
                 <div class="col-md-5 col-sm-5 col-xs-12">
                   <table class="table">
                    <tbody>
                    <tr>
                          <th colspan="2" rowspan="13" width="50%"  style="border:none;">Remarks<textarea class="form-control" id="remarks" rows="13"></textarea></th>
                          </tr>
                    </tbody>
                   </table>
                 </div>
             </div>
           </td>
            
           </tr>
         </thead>
       
     </table>
     
     <table class="table table-bordered" style="border-top:none !important; margin-top:-20px;">
       <tr>
  <th colspan="2" class="border-top-none"><label>Pur.Mgr</label>
  <input type="text" class="form-control" name="auth_mgr" id="pur_manager" value="${fullname}"></th>
  <th colspan="2" class="border-top-none"><label>Pur.Authorized</label><input type="text" class="form-control" name="pur_authorized" id="pur_authorized" value=""></th>
  <th class="border-top-none"><label>Plant Mgr</label><input type="text" class="form-control" name="plant_mgr" id="plant_mgr"></th>
  <th class="border-top-none"><label>Acct Mgr</label><input type="text" class="form-control" name="acct_mgr" id="acct_mgr"></th>
  <th class="border-top-none"><label>Authorized</label><input type="text" class="form-control" name="auth_mgr" id="auth_mgr"></th>
   <th class="border-top-none"><label>Due Date</label><input type="text" class="form-control" name="due_date" id="due_date"></th>
</tr>
     </table>
       
  </div>
  <div class="form-group">
				<input type="button" id="invoicesubmit"  class="btn-primary btn-lg no-radius center-block btn-sub my-btn" value="Submit">
					      <input type="hidden" id="csrfToken" value="${_csrf.token}"/>
				<input type="hidden" id="csrfHeader" value="${_csrf.headerName}"/>
                  
                </div>
                <br>

</form>
                  
                </div>
              </div>
            </div>
          </div>
		  <script>
		  $(document).ready(function(){
	$("#invoicesubmit").click(function(){
		if($("#purchaseForm").valid())
		{
				var model = {}
	       // model ["billReportLotNo"] = $("#pur_lot_no").val();
			model ["billDriverName"]=$("#pur_driver").val();
			model ["billGraderName"]=$("#pur_grader").val();
		    model ["billSupervisorName"]=$("#formarName").val();
			model ["billPurchageAuthorized"]=$("#pur_authorized").val();
			model ["billPlantManager"]=$("#plant_mgr").val();
			model ["billAccountManager"]=$("#acct_mgr").val();
			model ["billAuthorized"]=$("#auth_mgr").val();	
			model ["billPurchageManager"]=$("#pur_manager").val();
			//model ["billCertificate"]=$("#auth_mgr").val();	
			model ["billDispatchedBvrm"]=$('#billDispatchedBvrm').val();
			model ["billDispatchedNsp"]=$('#billDispatchedNsp').val();
			model["totalInvoiceQuantity"]=$('#billPurchaseQtyTotal').val();
			model["totalInvoiceAmt"]=$('#billPurchaseInVoiceAmtTotal').val();
			model ["billNoCertificate"]=$('#billNoCertificate').val();
			model ["billCertificate"]=$('#billCertificate').val();
			
			model ["billRemarks"]=$('#remarks').val();
			model ["billDueDate"]=new Date($("#due_date").val());
			var purchageTubDetails = [];
			var billReportLotNo={};
			var $headers = $("#tub_dtl thead th");
							var $rows = $("#tub_dtl tbody tr").each(function(index,table) {
								//alert($(table).html());
				  $cells = $(this).find("td");
				  purchageTubDetails[index] = {};
				  $cells.each(function(cellIndex,element) {

						purchageTubDetails[index][$(element).find('input[name^="tub_"]').attr('id')] = $(this).find("input").val();
					 
				  });    
				});
//compCount details
				var purchageCompDetails = [];
				var $rows = $("#compCountDtl tr").each(function(trindex,rowObject)
				{
				purchageCompDetails[trindex] = {};
				var $inputsText = $(rowObject).find('input:text').each(function(index,element) {
				var strObj =String($(element).attr('name'));
				var objectVal=$(element).attr('name');

				if(strObj.startsWith("bill25kGCount") || strObj.startsWith("billdCompCount"))
				{
						purchageCompDetails[trindex][strObj.substring(0,strObj.indexOf("-"))] = $(element).val();
				}
					 
				     
				});
				});
				var comp_count={};
				comp_count["bill25kGCount"]=$("#25_kg_count").val();
				comp_count["billPeeling"]=$("#peeling_count").val();
				comp_count["billDiscolored"]=$("#discoloured_count").val();
				comp_count["billBlackSpot"]=$("#blackspot_count").val();
				var purchageQuantityDetails = [];
				var totalRowTracker=0;
				var isValidCond=false;
				var $tables = $("#quantitylist").find('table').each(function(index,objtable)
				{
					if($(objtable).attr('id')!='graderNameTable')
					{
						var purachseTotalAmtPerQty=0.000;

					var rows=$(objtable).find('tbody tr').each(function(indexrow,objtablerow)
					{
						 purchageQuantityDetails[totalRowTracker] = {};

						$(objtablerow).find("td").each(function(cellIndex,element) {
							//alert($(element).find('select').is("select"));
							//alert($(element).find("option:selected").val());
							//alert($(element).html().type);
							if(!$(element).find('select').is("select"))
							{
							purchageQuantityDetails[totalRowTracker][$(element).attr('class')] =$(element).find("input").val();
							var idBillQty=String($(element).find("input").attr('id'));
							if(idBillQty.startsWith('billPurchageQuantity'))
							{
								var elementValue=$(element).find("input").val();
								var tempPurchaseValue=parseFloat(elementValue) || 0.000;
								purachseTotalAmtPerQty=parseFloat(purachseTotalAmtPerQty)+tempPurchaseValue;
								
							}
							}
							else{

								purchageQuantityDetails[totalRowTracker][$(element).attr('class')]=$(element).find("option:selected").val();
							}
							
						});
							totalRowTracker++;
					
					});
						var hiddenObjectValue=$(objtable).find("input:hidden").val();
						var totalCountQty=parseFloat(hiddenObjectValue)|| 0.000;
						if(purachseTotalAmtPerQty>totalCountQty)
						{
							isValidCond=true;
						}
					}
				});
				if(isValidCond)
				{
				alert("Total Purchase Quantity should not exceed Total Weighment Quantity Per Count");
				return false;
				}
				totalRowTracker=0;
				purchageQuantityDetails = JSON.stringify(purchageQuantityDetails,replacer);
				purchageQuantityDetails=jQuery.parseJSON(purchageQuantityDetails)
				checkEmptyObj(purchageQuantityDetails);
				
				purchageCompDetails = JSON.stringify(purchageCompDetails,replacer);
				purchageCompDetails=jQuery.parseJSON(purchageCompDetails)
				checkEmptyObj(purchageCompDetails);
				//checkEmptyObj(purchageQuantityDetails);
			//	removeEmptyElementFromArray(jQuery.parseJSON(purchageQuantityDetails));
					//console.log(purchageQuantityDetails);
					billReportLotNo["billLotNo"]=$("#pur_lot_no").val();
					billReportLotNo["billChequeName"]=$("#chequeName").val();
					billReportLotNo["billFormerName"]=$("#farmerName").val();
					billReportLotNo["billFormerMobile"]=$("#formerMobile").val();
					billReportLotNo["billAgentName"]=$("#agentName").val();
					billReportLotNo["billAgentMobile"]=$("#agentMobile").val();
					billReportLotNo["billPlace"]=$("#place").val();
					billReportLotNo["billDate"]=$("#billDate").val();
					billReportLotNo["billTruckNUmber"]=$("#truckNumber").val();
					billReportLotNo["billSupervisorName"]=$("#supervisorName").val();	
					model.billReportLotNo=billReportLotNo;
					model.purchagePayAmount=purchageQuantityDetails;
					model.purchageBillTubs = purchageTubDetails;
					model.purchageCompCountDetail = purchageCompDetails;
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
	    	$("#weighmenthtml").empty();
			$("#weighmenthtml").html('<p>Your purchase order has been created for your lot no:'+result.billReportLotNo.billLotNo+'</p>');
		
	    },
	    error : function(jqXHR, textStatus, errorThrown) {
	        var exceptionVO = jQuery.parseJSON(jqXHR.responseText);
	        alert("errorOccured Form Submission is not happening"+jqXHR.status+exceptionVO.errMsg+exceptionVO.errCode+exceptionVO.errorMethod);
			    }
			});//ajax
		}
			});
		});
		function removeEmptyElementFromArray(collectionObj)
		{
			
			jQuery.each(collectionObj, function(i, val) {
				//alert(jQuery.isEmptyObject(val));
	   if(jQuery.isEmptyObject(val) == true) // delete index
	   {
			
			collectionObj.splice(i);
	       
	  }
	 

	});
		}
		
		function checkEmptyObj(purchageQuantityDetails) {
	      $.each(purchageQuantityDetails, function(key, value) {
	        if ($.isPlainObject(value) || $.isArray(value)) {
	          checkEmptyObj(value);
	        }
	        //alert(key+":"+$.isEmptyObject(value));
	        if (value === "" || value === null || $.isEmptyObject(value)) {
	          delete purchageQuantityDetails[key];
	        }
	      });

	    }

		function replacer(key, value) {
	  // Filtering out properties
	  if (value == "") {
	     return undefined;
	  }
	  return value;
		}
	function claculatePurchaseAmount()
	{
			var totalRowTracker1=0;
			var totalPurchaseQuantityAmt=0.000;
			var totalInvoiceAmt=0.000;
						var $tables = $("#quantitylist").find('table').each(function(index,objtable)
						{
							var rows=$(objtable).find('tbody tr').each(function(indexrow,objtablerow)
							{
								var roundingPurQty=0.000;
								$(objtablerow).find("td").each(function(cellIndex,element) {
									var purQtyIdVal=$(element).find('input').attr('id');
									var purQtyInputVal=$(element).find('input').val();
									if(purQtyInputVal != undefined && purQtyInputVal!="")
									{		
										if(String(purQtyIdVal).startsWith("billPurchageQuantity"))
										{
									   //alert(purQtyInputVal);
										 roundingPurQty = parseFloat(purQtyInputVal) || 0.000;
										totalPurchaseQuantityAmt=totalPurchaseQuantityAmt+roundingPurQty;
											$("#billPurchaseQtyTotal").val(totalPurchaseQuantityAmt);
									}
									else if(String(purQtyIdVal).startsWith("billPurchageRate"))
									{
										//alert(purQtyInputVal);
										var roundingPurRate = parseFloat(purQtyInputVal) || 0.000;
										 totalInvoiceAmt=totalInvoiceAmt+(roundingPurQty*roundingPurRate);
										
									}
								}
									
								});
									totalRowTracker1++;
							
							});
							
						});
						
						$("#billPurchaseInVoiceAmtTotal").val(totalInvoiceAmt.toFixed(3));
						$("#billPurchaseQtyTotal").val(totalPurchaseQuantityAmt.toFixed(3));
						
						totalRowTracker1=0;
		}
	
	
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
	  
	  $("#billCertificate").on('change', function() {
		  if ($(this).is(':checked')) {
		    $(this).attr('value', 'true');
		  } else {
		    $(this).attr('value', 'false');
		  }
		  
			$('#checkbox-value').text($('#billCertificate').val());
	  });
	  
	  
	  $("#billNoCertificate").on('change', function() {
		  if ($(this).is(':checked')) {
		    $(this).attr('value', 'true');
		  } else {
		    $(this).attr('value', 'false');
		  }
		  
			$('#checkbox-value').text($('#billNoCertificate').val());
	  });
	  
	  
	  function cal1kgCount(value,id)
	  {
		  
		 var valueString=id.substring(id.indexOf("-")+1);
		// alert("in side Calcount"+valueString);
		 var totalPiece = parseInt(value)/25 || 0;
		  $('#totalPiecies-'+valueString).val(totalPiece);
	  }
	  $(document).ready(function(){
		// initialize the plugin on DOM ready
		    $("#purchaseForm").validate({ 
		        // all rules and options,
		        rules: {
		            
					
					 plantsIdPurchase: {
		                selectcheck: true
		            }
					
					
		        }
		    });
			
		 jQuery.validator.addMethod('selectcheck', function (value) {
			// alert(value);
		        return (value != '0');
		    }, "Plant Name is required");
			 
		});
	  
	  $( function() {
		    $( "#due_date" ).datepicker();
			//$("#dispatch_time").timepicker();
			
			
	} );
	  
	  $(document).ready(function(){
			/* var weighmentDraftArray=[];
			  <c:forEach var="array" items="${weighmentPurchase.totalCountQuantity}">
			  weighmentDraftArray.push({
	 <c:out value="${array.key}"></c:out> : <c:out value="${array.value}"></c:out>,
  
	});
          alert(JSON.stringify(weighmentDraftArray));
      </c:forEach>*/
			  claculatePurchaseAmount();
		  });
		  </script>