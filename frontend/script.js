$(document).ready(function() {
   $.ajax({
       url: "http://localhost:8080/api/trainings"
   }).then(function(data) {
      var trHTML = '';
      var termin = ''
      var id ='';
      $.each(data, function (i, item) {
        
          trHTML += '<tr class="table-row" id='+item.id+'><td>' + item.id+'</td><td contenteditable="true">' + item.name+'</td><td>' + item.description + '</td><td>' + item.price + '&nbsp;Euro</td></tr>';
          $.each(item.appointments, function (j, appointment) {
              id = "appoinment-row"+item.id
              appid = 'appoinment_training_'+appointment.id+'_'+item.id
              termin += '<div  id='+id+' style="display: none;" class="row"><div class="col-2"><input type="radio" name="course" id='+appid+' value='+appointment.id+'></div><div class="col-4">'+appointment.startDate+'</div><div class="col-4">'+appointment.endDate+'</div><div class="col-2">'+appointment.period+'&nbsp;days</div></div>';
          });
    });
    
    $('#records_training').append(trHTML);
    $('#records_appoinment').append(termin);
    console.log(data);
   });
   
   $(document).on('click', '.table-row', function(e) {
       
      $('#records_appoinment').show();

      $('[id^=appoinment-row]').hide();
      
      $('[id^=appoinment-row'+this.id+']').show();
      
      $('#form_book_div').show();
      

      $('[class^=table-row]').css('background', 'white');
      
      document.getElementById('training_id').value=this.id;
      
      $('[id^=appoinment__training_]').each(function(){
          if (this.checked)   
              document.getElementById('appoinment_id').value= this.value;
      });
      
      
      
      
      $(this).css('background', 'orange');
   
    });
   
});

function book(sd){
    
    var data = $('#form_book').serializeArray().reduce(function(obj, item) {
        obj[item.name] = item.value;
        return obj;
    }, {});
    
    var radios = document.getElementsByName('course');
    for (var i = 0, length = radios.length; i < length; i++) {
    if (radios[i].checked) {
        // do whatever you want with the checked radio
        var appoint=radios[i].value;

        // only one radio can be logically checked, don't check the rest
        break;
    }
    }

    console.log(data.emailID, data.training, appoint);
    
    var markers = { "user": data.emailID, "training": data.training,"appoinment": appoint};

     
     $.ajax({
      type: 'POST',
      url: "http://localhost:8080/api/booking",
      data: JSON.stringify(markers),
      error: function(e) {
        console.log(e);
      },
      dataType: "json",
      contentType: "application/json"
    });
  
  
}

