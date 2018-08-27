function showMe() {

		var tip = document.getElementById("tip").value;
		var div1 = document.getElementById("siklar");
		var div2 = document.getElementById("soru_dogru_normal_div");
		
		
		var soru_dogru_normal=document.getElementById("soru_dogru_normal");
		var soru_dogru=document.getElementById("soru_dogru_cs");
		
		var soru_A=document.getElementById("soru_A");
		var soru_B=document.getElementById("soru_B");
		var soru_C=document.getElementById("soru_C");
		var soru_D=document.getElementById("soru_D");
		var soru_E=document.getElementById("soru_E");
		
		
		if (tip==1 | tip==3) {
			
			soru_A.disabled=true;
			soru_B.disabled=true;
			soru_C.disabled=true;
			soru_D.disabled=true;
			soru_E.disabled=true;
			
			soru_dogru_normal.disabled=false;
			soru_dogru.disabled=true;
			div2.style.display = "block";
			div1.style.display = "none";
				

		}
		
		if (tip==2) {
			
			soru_A.disabled=false;
			soru_B.disabled=false;
			soru_C.disabled=false;
			soru_D.disabled=false;
			soru_E.disabled=false;
			
			soru_dogru_normal.disabled=true;
			soru_dogru.disabled=false;
			div2.style.display ="none";
			div1.style.display="block"
			
			
		}
	
		
	

		
		
	}
