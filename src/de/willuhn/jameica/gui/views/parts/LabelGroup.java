/**********************************************************************
 * $Source: /cvsroot/jameica/jameica/src/de/willuhn/jameica/gui/views/parts/Attic/LabelGroup.java,v $
 * $Revision: 1.10 $
 * $Date: 2003/12/26 21:43:30 $
 * $Author: willuhn $
 * $Locker:  $
 * $State: Exp $
 *
 * Copyright (c) by willuhn.webdesign
 * All rights reserved
 *
 **********************************************************************/
package de.willuhn.jameica.gui.views.parts;

import java.rmi.RemoteException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import de.willuhn.jameica.I18N;
import de.willuhn.jameica.gui.GUI;
import de.willuhn.jameica.gui.views.util.Style;

/**
 * @author willuhn
 */
public class LabelGroup
{

  private Group group = null;

  /**
   * Diese Klasse kapselt Dialog-Teile des Typs:
   * Gruppe mit Bezeichnung und da drin eine Liste von
   * Label- und Eingabefeldpaaren.
   * @param parent Das Composite, in dem die Group gemalt werden soll.
   * @param name Name der Group.
   */
  public LabelGroup(Composite parent, String name)
  {
    group = new Group(parent, SWT.NONE);
    group.setText(name);
    group.setLayout(new GridLayout(2, false));
    GridData grid = new GridData(GridData.FILL_HORIZONTAL);
    group.setLayoutData(grid);
  }
  
  /**
   * Fuegt ein weiteres Label-Paar hinzu.
   * @param name Name des Feldes.
   * @param input Das Eingabefeld.
   */
  public void addLabelPair(String name, Input input)
  {
    // Label
    final GridData labelGrid = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
    labelGrid.widthHint = 130;
    labelGrid.verticalAlignment = GridData.BEGINNING;
    final Label label = new Label(group, SWT.NONE);
    label.setText(name);
    label.setLayoutData(labelGrid);

    // Inputfeld
    input.paint(group);
  }
  
  /**
   * Fuegt Freitext zur Group hinzu.
   * @param text der anzuzeigende Text.
   * @param linewrap legt fest, ob der Text bei Erreichen der maximalen Breite umgebrochen werden darf.
   */
  public void addText(String text, boolean linewrap)
  {
    final GridData labelGrid = new GridData(GridData.FILL_HORIZONTAL);
    labelGrid.horizontalSpan = 2;
    final Label label = new Label(group,linewrap ? SWT.WRAP : SWT.NONE);
    label.setText(text);
    label.setLayoutData(labelGrid);
  }

  /**
   * Fuegt eine Tabelle zur Group hinzu.
   * @param anzuzeigende Tabelle.
   */
  public void addTable(Table table)
  {
    try {
      final GridData grid = new GridData(GridData.FILL_HORIZONTAL);
      grid.horizontalSpan = 2;
      final Composite comp = new Composite(group,SWT.NONE);
      comp.setLayoutData(grid);

      GridLayout layout = new GridLayout(1,true);
      layout.marginHeight = 0;
      layout.marginWidth = 0;
      comp.setLayout(layout);

      table.paint(comp);
    }
    catch (RemoteException e)
    {
      GUI.setActionText(I18N.tr("Fehler beim Lesen der Tabelle"));
    }
  }

  /**
   * Fuegt eine Zwischenueberschrift zur Group hinzu.
   * @param text die anzuzeigende Ueberschrift.
   */
  public void addHeadline(String text)
  {
    final GridData labelGrid = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
    labelGrid.horizontalSpan = 2;
    labelGrid.widthHint = 400;
    final Label label = new Label(group,SWT.NONE);
    label.setFont(Style.FONT_HEADLINE);
    label.setText(text);
    label.setLayoutData(labelGrid);
    addSeparator();
  }
  
  /**
   * Fuegt eine Trennzeile ein.
   */
  public void addSeparator()
  {
    final GridData lineGrid = new GridData(GridData.FILL_HORIZONTAL);
    lineGrid.horizontalSpan = 2;
    final Label line = new Label(group,SWT.SEPARATOR | SWT.HORIZONTAL);
    line.setLayoutData(lineGrid);
  }
}

/*********************************************************************
 * $Log: LabelGroup.java,v $
 * Revision 1.10  2003/12/26 21:43:30  willuhn
 * @N customers changable
 *
 * Revision 1.9  2003/12/19 13:36:59  willuhn
 * *** empty log message ***
 *
 * Revision 1.8  2003/12/19 01:43:27  willuhn
 * @N added Tree
 *
 * Revision 1.7  2003/12/11 21:00:54  willuhn
 * @C refactoring
 *
 * Revision 1.6  2003/12/10 00:47:12  willuhn
 * @N SearchDialog done
 * @N ErrorView
 *
 * Revision 1.5  2003/12/01 20:28:57  willuhn
 * @B filter in DBIteratorImpl
 * @N InputFelder generalisiert
 *
 * Revision 1.4  2003/11/24 14:21:53  willuhn
 * *** empty log message ***
 *
 * Revision 1.3  2003/11/23 19:26:27  willuhn
 * *** empty log message ***
 *
 * Revision 1.2  2003/11/21 02:10:21  willuhn
 * @N prepared Statements in AbstractDBObject
 * @N a lot of new SWT parts
 *
 * Revision 1.1  2003/11/20 03:48:42  willuhn
 * @N first dialogues
 *
 **********************************************************************/