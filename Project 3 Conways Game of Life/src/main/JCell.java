package main;

public class JCell {
	
private Boolean m_alive;
private Boolean m_changed;
private Boolean m_nextState;
public JCell()
{
m_alive = m_changed = m_nextState = false;
}

public Boolean isAlive()
{
return m_alive;
}
public void SetNextState(Boolean nextState)
{
m_changed = true;
m_nextState = nextState;
}
public void SetCurrentState(Boolean alive)
{
m_alive = m_nextState = alive;
}
public void Iterate()
{
m_alive = m_nextState;
m_changed = false;
}


}
