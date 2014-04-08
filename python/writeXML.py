#http://stackoverflow.com/questions/3605680/creating-a-simple-xml-file-using-python
import xml.etree.cElementTree as ET

root = ET.Element("root")

doc = ET.SubElement(root, "doc")

field1 = ET.SubElement(doc, "field1")
field1.set("name", "blah")
field1.text = "some value1"

field1 = ET.SubElement(doc, "field2")
field1.set("name", "asdfasd")
field1.text = "some vlaue2"

tree = ET.ElementTree(root)
tree.write("filename.xml")
