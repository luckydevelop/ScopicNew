#Region ;**** Directives created by AutoIt3Wrapper_GUI ****
#AutoIt3Wrapper_Outfile_x64=autoit_script.exe
#EndRegion ;**** Directives created by AutoIt3Wrapper_GUI ****

  Local $hWnd = WinWait("[CLASS:#32770]","",10)


  ControlFocus($hWnd,"","Edit1")


  Sleep(2000)


ControlSetText($hWnd, "", "Edit1", "K:\Job\Testing\Scopic\src\main\resources\images\lego.jpg")

  Sleep(2000)


  ControlClick($hWnd, "","Button1");