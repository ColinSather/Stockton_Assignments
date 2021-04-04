import RLPy
import os
import numpy as np
import wave
from PySide2 import *
from PySide2.shiboken2 import wrapInstance

window = RLPy.RUi.CreateRDockWidget()
window.SetWindowTitle("Audio Visualizer (Mono)")
window.SetAllowedAreas(RLPy.EDockWidgetAreas_BottomDockWidgetArea)

dock = wrapInstance(int(window.GetWindow()), QtWidgets.QDockWidget)
dock.resize(1000, 300)

ui = QtCore.QFile(os.path.dirname(__file__) + "/Audio_Visualizer.ui")
ui.open(QtCore.QFile.ReadOnly)
widget = QtUiTools.QUiLoader().load(ui)
ui.close()

widget.progressBar.setVisible(False)

dock.setWidget(widget)