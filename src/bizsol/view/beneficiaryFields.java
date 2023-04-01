package bizsol.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class beneficiaryFields extends JTextField{

			Dimension dim = new Dimension(130,25);
			BizSolTextfield b1Name = new BizSolTextfield(dim);
			BizSolTextfield b1Address = new BizSolTextfield(dim);
			BizSolTextfield b1contact = new BizSolTextfield(dim);
			BizSolTextfield b1relation = new BizSolTextfield(dim);
			
			BizSolTextfield b2Name = new BizSolTextfield(dim);
			BizSolTextfield b2Address = new BizSolTextfield(dim);
			BizSolTextfield b2contact = new BizSolTextfield(dim);
			BizSolTextfield b2relation = new BizSolTextfield(dim);
			
			BizSolTextfield b3Name = new BizSolTextfield(dim);
			BizSolTextfield b3Address = new BizSolTextfield(dim);
			BizSolTextfield b3contact = new BizSolTextfield(dim);
			BizSolTextfield b3relation = new BizSolTextfield(dim);
			
			JTextField[] ee = {b1Name,b1Address,b1contact,b1relation,
					b2Name,b2Address,b2contact,b2relation,
					b3Name,b3Address,b3contact,b3relation};
			
			GridBagConstraints grd = new GridBagConstraints();
	
			beneficiaryFields(JPanel panel){
				BizSolLabel namepanelLabel = new BizSolLabel("Name",panel, 110, 20,grd,0,0);
				BizSolLabel AddresspanelLabel = new BizSolLabel("Address",panel,110,20,grd,1,0);
				BizSolLabel contactpanelLabel = new BizSolLabel("Contact No.",panel,110,20,grd,2,0);
				BizSolLabel realtionpanelLabel = new BizSolLabel("Relationship",panel,110,20,grd,3,0);
					
				for(int y=1;y<=3;y++) {
					grd.gridy=y;
					switch(y){
						case 1:
								for(int x=0;x<=3;x++) {
								grd.gridx=x;
								panel.add(ee[x],grd);
								}
						break;
						case 2: for(int x=4;x<=7;x++) {
								grd.gridx=x-4;
								panel.add(ee[x],grd);
								}
						break;
						case 3: for(int x=8;x<=11;x++) {
								grd.gridx=x-8;
								panel.add(ee[x],grd);
								}
					}
					
				}
	
	
			}
}
