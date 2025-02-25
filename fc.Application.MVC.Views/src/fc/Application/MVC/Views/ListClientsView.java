package fc.Application.MVC.Views;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;

import fc.Application.MVC.Controllers.EditClientController;
import fc.Application.MVC.Controllers.ListClientsController;
import fc.Application.MVC.Controllers.ListCommandesController;
import fc.Application.MVC.ViewModels.ClientViewModel;
import fc.Application.MVC.ViewModels.CommandeViewModel;
import fc.Application.MVC.ViewModels.DataContainer;

import org.eclipse.swt.events.TouchListener;
import org.eclipse.swt.events.TouchEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ListClientsView extends Dialog {

	protected Object result;
	protected Shell shell;
	private Table table;
	
	public RunController m_Infrastructure;
	
	protected DataContainer getViewModel()
	{
		if (m_Infrastructure != null)
			return (DataContainer)m_Infrastructure.m_ViewModel;
		else
			return new DataContainer();
	}
	

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ListClientsView(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(685, 536);
		shell.setText(getText());
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 70, 20);
		lblNewLabel.setText("Clients:");
		
		Button btnEditer = new Button(shell, SWT.NONE);
		
		btnEditer.setBounds(567, 47, 90, 30);
		btnEditer.setText("Editer");
		
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 104, 647, 333);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNom = new TableColumn(table, SWT.NONE);
		tblclmnNom.setWidth(200);
		tblclmnNom.setText("Numero commande");
		
		TableColumn tblclmnPrenom = new TableColumn(table, SWT.NONE);
		tblclmnPrenom.setWidth(198);
		tblclmnPrenom.setText("Date");
		
		CommandeViewModel[] cs = getViewModel().commandes;
		for (CommandeViewModel c : cs)
		{
		    TableItem item = new TableItem(table, SWT.NONE);
		    item.setText(new String[] { ""+c.getId(), ""+c.getOrderDate()});
		}
		
		Button btnVoirDetailsCommandes = new Button(shell, SWT.NONE);
		btnVoirDetailsCommandes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				m_Infrastructure.runController(shell,ListCommandesController.class,getViewModel().commandes[table.getSelectionIndex()].getId());
			}
		});
		btnVoirDetailsCommandes.setBounds(480, 449, 177, 30);
		btnVoirDetailsCommandes.setText("Voir details commandes");
		
		CCombo combo = new CCombo(shell, SWT.BORDER);
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				m_Infrastructure.runController(shell,ListClientsController.class,getViewModel().customers[combo.getSelectionIndex()].getId());
			}
		});
		combo.setBounds(34, 52, 510, 25);
		for(ClientViewModel c: getViewModel().customers) {
			combo.add(c.getNom() +" "+ c.getPrenom());
		}
		combo.select(getViewModel().clientSelectionne.getId()-2);
		
		btnEditer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				m_Infrastructure.runController(shell,EditClientController.class,getViewModel().customers[combo.getSelectionIndex()].getId());
			}
		});

	}
}
