# from . import data
# from . import data
# from data import DataManager
import sys

sys.path.append('../data')
import DataManager
sys.path.append('../logger')
import Logger
#import pythonCode.data.DataManager
#import pythonCode.logger.Logger

print("Logger" in sys.modules)

class deneme:
    xyz = 0
    
    def __init__(self):
        self.merhaba = 12
        self.denemeler = 24

        self.__ikinci_merhaba = 8
        self.__ikinci_denemeler = 16

    def setIkinciMerhaba(self, sayi):
        self.__ikinci_merhaba = sayi

    def getIkinciMerhaba(self):
        return self.__ikinci_merhaba
    
    def getIkinciDenemeler(self):
        return self.__ikinci_denemeler

print ("deneme.xyz: " + str(deneme.xyz))
deneme.xyz = 10
print ("deneme.xyz: " + str(deneme.xyz))


obje = deneme()
print ("obje.merhaba: " + str(obje.merhaba))
print ("obje.denemeler: " + str(obje.denemeler))

obje.merhaba = 120
obje.denemeler = 240
obje.xyz = -1

print ("obje.merhaba: " + str(obje.merhaba))
print ("obje.denemeler: " + str(obje.denemeler))
print ("obje.xyz: " + str(obje.xyz))

print ("deneme.xyz: " + str(deneme.xyz))

print ("obje.__ikinci_merhaba: " + str(obje.getIkinciMerhaba()))
print ("obje.__ikinci_denemeler: " + str(obje.getIkinciDenemeler()))

obje.setIkinciMerhaba(999)
print ("obje.__ikinci_merhaba: " + str(obje.getIkinciMerhaba()))

DataManager.DataManager.getInstance().hello()

# Logger.Logger.getLogger("denemelog").info("MERHABA")

logger = Logger.Logger.getLogger("denemelog")

logger.error("hatamesajiiii")
logger.info("infomesajii")