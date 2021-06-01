
Public Class Form1

    Public Declare Function Everything_SetSearchA Lib "d:\dev\everything\sdk\dll\Everything32.dll" (ByVal search As String) As UInt32
    Public Declare Function Everything_SetRequestFlags Lib "d:\dev\everything\sdk\dll\Everything32.dll" (ByVal dwRequestFlags As UInt32) As UInt32
    Public Declare Function Everything_QueryA Lib "d:\dev\everything\sdk\dll\Everything32.dll" (ByVal bWait As Integer) As Integer
    Public Declare Function Everything_GetNumResults Lib "d:\dev\everything\sdk\dll\Everything32.dll" () As UInt32
    Public Declare Function Everything_GetResultFileNameA Lib "d:\dev\everything\sdk\dll\Everything32.dll" (ByVal index As UInt32) As String
    Public Declare Function Everything_GetLastError Lib "d:\dev\everything\sdk\dll\Everything32.dll" () As UInt32
    Public Declare Function Everything_GetResultFullPathNameA Lib "d:\dev\everything\sdk\dll\Everything32.dll" (ByVal index As UInt32, ByVal buf As System.Text.StringBuilder, ByVal size As UInt32) As UInt32
    Public Declare Function Everything_GetResultSize Lib "d:\dev\everything\sdk\dll\Everything32.dll" (ByVal index As UInt32, ByRef size As UInt64) As Integer
    Public Declare Function Everything_GetResultDateModified Lib "d:\dev\everything\sdk\dll\Everything32.dll" (ByVal index As UInt32, ByRef ft As UInt64) As Integer

    Public Const EVERYTHING_REQUEST_FILE_NAME = &H1
    Public Const EVERYTHING_REQUEST_PATH = &H2
    Public Const EVERYTHING_REQUEST_FULL_PATH_AND_FILE_NAME = &H4
    Public Const EVERYTHING_REQUEST_EXTENSION = &H8
    Public Const EVERYTHING_REQUEST_SIZE = &H10
    Public Const EVERYTHING_REQUEST_DATE_CREATED = &H20
    Public Const EVERYTHING_REQUEST_DATE_MODIFIED = &H40
    Public Const EVERYTHING_REQUEST_DATE_ACCESSED = &H80
    Public Const EVERYTHING_REQUEST_ATTRIBUTES = &H100
    Public Const EVERYTHING_REQUEST_FILE_LIST_FILE_NAME = &H200
    Public Const EVERYTHING_REQUEST_RUN_COUNT = &H400
    Public Const EVERYTHING_REQUEST_DATE_RUN = &H800
    Public Const EVERYTHING_REQUEST_DATE_RECENTLY_CHANGED = &H1000
    Public Const EVERYTHING_REQUEST_HIGHLIGHTED_FILE_NAME = &H2000
    Public Const EVERYTHING_REQUEST_HIGHLIGHTED_PATH = &H4000
    Public Const EVERYTHING_REQUEST_HIGHLIGHTED_FULL_PATH_AND_FILE_NAME = &H8000

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click

        Everything_SetSearchA(TextBox1.Text)
        Everything_SetRequestFlags(EVERYTHING_REQUEST_FILE_NAME Or EVERYTHING_REQUEST_PATH Or EVERYTHING_REQUEST_SIZE Or EVERYTHING_REQUEST_DATE_MODIFIED)
        Everything_QueryA(1)

        Dim NumResults As UInt32
        Dim i As UInt32
        Dim filename As New System.Text.StringBuilder(260)
        Dim size As UInt64
        Dim ftdm As UInt64
        Dim DateModified As System.DateTime

        NumResults = Everything_GetNumResults()

        ListBox1.Items.Clear()

        If NumResults > 0 Then
            For i = 0 To NumResults - 1

                Everything_GetResultFullPathNameA(i, filename, filename.Capacity)
                Everything_GetResultSize(i, size)
                Everything_GetResultDateModified(i, ftdm)

                DateModified = System.DateTime.FromFileTime(ftdm)

                ListBox1.Items.Insert(i, filename.ToString() & " size:" & size & " date:" & DateModified.ToString())

            Next
        End If

    End Sub

End Class
